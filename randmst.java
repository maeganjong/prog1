import java.io.*;
import java.util.Random;
import java.lang.Math;

public class randmst{
	public static void main (String[] args) {
        // args[0] - 0, args[1] - numpoints, args[2] - numtrials, args[3] - dimension

        int bool = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int times = Integer.parseInt(args[2]);
        int dim = Integer.parseInt(args[3]);

				long startTime = 0;
        if (bool == 1) {
            startTime = System.nanoTime();
        }

        double arr[] = new double[n]; // shortest segment to that vertex
        double sum = 0;
        double total_sum = 0;

        Random rand = new Random();

        for (int count = 0; count < times; count++) {
						long seed = System.currentTimeMillis() % 1000; //define to something random
						rand.setSeed(seed);
						sum = 0;

            if (dim == 0) { // for the 0th dimension
                double min = 2;
                int min_index = 0;
                for (int j = 0; j < n; j++) { //first populate this area with a value larger than possible generated from RNG
                    arr[j] = 2;
                }

								// generate again; if less than replace
                for (int j = 0; j < n; j++){
                    for (int i = 0; i < n; i++) {
                        if (arr[i] >= 0) {
                            double value = rand.nextDouble();
                            if (value < arr[i]) {
                                arr[i] = value;
                            }
                            if (arr[i] < min) {
                                min = (float) arr[i];
                                min_index = i;
                            }
                        }
                    }
                    sum += arr[min_index];
                    arr[min_index] = -1; //add the shortest distance node to the MST by marking it
                    min = 2;
                }
            }

            else {
                double min = dim; // conservative estimate for minimum value of distances
                double point[][] = new double[n][dim]; // matrix for all of your points

                // generate point for arr[0] - arbitrary point

                for (int j = 0; j < n; j++) { //first populate this area with a value larger than possible generated from RNG
                    arr[j] = min;
										for (int i = 0; i < dim; i++) {
											point[j][i] = rand.nextDouble();
										}
                }

								int min_index = 0;
								int temp_min = 0;
                arr[0] = 0;
                for (int j = 0; j < n; j++){

                    for (int i = 0; i < n; i++) {
                        if (arr[i] >= 0) {
														double dist;
														double subdist = 0;
														for (int d = 0; d < dim; d++) {
															subdist += (point[i][d] - point[min_index][d])*(point[i][d] - point[min_index][d]);
														}
                            dist = Math.sqrt(subdist);

                            // System.out.println("min index: " + min_index + " i: " + i + " dist: " + dist);

														if (dist < arr[i]) {
                                arr[i] = dist;
                            }

                            if (arr[i] < min) {
                                min = arr[i];
                                temp_min = i;
                                // System.out.println("min has changed to -> " + min);
                            }
                        }
                    } // end i loops

                    // System.out.println("Break point **** " + arr[min_index]);
										// System.out.println("min index " + min_index);
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
