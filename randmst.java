import java.io.*;
import java.util.Random;
import java.lang.Math;

public class randmst{
	public static void main (String[] args) {
        // defines the command-line arguments
        // args[0] - 0, args[1] - numpoints, args[2] - numtrials, args[3] - dimension
        int bool = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int times = Integer.parseInt(args[2]);
        int dim = Integer.parseInt(args[3]);

				long startTime = 0;
        if (bool == 1) {
            startTime = System.nanoTime(); // stores the current time
        }

        double arr[] = new double[n]; // shortest segment to that vertex
        double sum = 0; // sum for each trial
        double total_sum = 0;

        Random rand = new Random();

        for (int count = 0; count < times; count++) {
						long seed = System.currentTimeMillis() % 1000; //define so it seeds to machine code
						rand.setSeed(seed);
						sum = 0;

            if (dim == 0) { // for the 0th dimension
                double min = 2;
                int min_index = 0;
                for (int j = 0; j < n; j++) { //first populate this area with a value larger than possible generated from RNG
                    arr[j] = 2;
                }

                for (int j = 0; j < n; j++){ // iterate n times for all the nodes
                    for (int i = 0; i < n; i++) { // goes through each node to find the minimum distance & update the array accordingly from the most recently added node
                        if (arr[i] >= 0) {
                            double value = rand.nextDouble();
                            if (value < arr[i]) {
                                arr[i] = value; // if the new distance is less the current value in the array, redefine the value in the array
                            }
                            if (arr[i] < min) {
                                min = (float) arr[i]; // redefine the minimum if the value is less than the constant
                                min_index = i;
                            }
                        }
                    }
                    sum += arr[min_index];
                    arr[min_index] = -1; //add the shortest distance node to the MST by marking it
                    min = 2;
                }
            }

            else { // all other dimensionS
                double min = dim; // conservative estimate for minimum value of distances
                double point[][] = new double[n][dim]; // matrix for all of your points

                for (int j = 0; j < n; j++) { //first populate this area with a value larger than possible generated from RNG
                    arr[j] = min;
										for (int i = 0; i < dim; i++) {
											point[j][i] = rand.nextDouble(); // generates the nodes for the entire graph
										}
                }

								int min_index = 0;
								int temp_min = 0; // min_index that will change throughout the iteration
                arr[0] = 0; // establish arbitrary starting point without loss of generality
                for (int j = 0; j < n; j++){ // iterate n times for all the nodes
                    for (int i = 0; i < n; i++) { // goes through each node to find the minimum distance & update the array accordingly from the most recently added node

                        if (arr[i] >= 0) {
														double dist;
														double subdist = 0;
														for (int d = 0; d < dim; d++) {
															subdist += (point[i][d] - point[min_index][d])*(point[i][d] - point[min_index][d]);
														}
                            dist = Math.sqrt(subdist); // calculates the distance between the points

														if (dist < arr[i]) {
                                arr[i] = dist; // if the new distance is less the current value in the array, redefine the value in the array
                            }

                            if (arr[i] < min) {
                                min = arr[i]; // redefine the minimum if the value is less than the constant
                                temp_min = i;
                            }
                        }
                    } // end i loop

                    min_index = temp_min;
										sum += arr[min_index];
                    arr[min_index] = -1; //add the shortest distance node to the MST by marking it
										min = dim; // reset min
                } // end j loop

            } // end else (dim) condition
            total_sum += sum;

						if (bool == 1) {
							System.out.println(sum);
							System.out.println("Time: " + (System.nanoTime() - startTime)/Math.pow(10,9) + "sec");
							startTime = System.nanoTime();
						}
        }

        System.out.println(total_sum / times + " " + n + " " + times + " " + dim);
    }
}
