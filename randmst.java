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

        float arr[] = new float[n];
        float sum = 0;
        float total_sum = 0;

        Random rand = new Random();

        for (int count = 0; count < times; count++) {
						long seed = System.currentTimeMillis() % 1000; //define to something random
						rand.setSeed(seed);
						sum = 0;

            if (dim == 0) { // for the 0th dimension
                float min = 2;
                int min_index = 0;
                for (int j = 0; j < n; j++) { //first populate this area with a value larger than possible generated from RNG
                    arr[j] = 2;
                }

								// generate again; if less than replace
                for (int j = 0; j < n; j++){
                    for (int i = 0; i < n; i++) {
                        if (arr[i] >= 0) {
                            float value = rand.nextFloat();
                            if (value < arr[i]) {
                                arr[i] = value;
                            }
                            if (arr[i] < min) {
                                min = arr[i];
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
                float min = n*n;
                float point[][] = new float[n][dim]; // matrix for all of your points

                // generate point for arr[0] - arbitrary point

                int min_index = 0;
                for (int j = 0; j < n; j++) { //first populate this area with a value larger than possible generated from RNG
                    arr[j] = min;
										for (int i = 0; i < dim; i++) {
											point[j][i] = rand.nextFloat();
										}
                }

                arr[0] = 0;
                for (int j = 0; j < n; j++){
                    for (int i = 0; i < n; i++) {
                        if (arr[i] >= 0) {
                            float dist = 0;
														for (int d = 0; d < dim; d++) {
															dist += (point[i][d] - point[min_index][d])*(point[i][d] - point[min_index][d]);
														}
														dist = (float) Math.sqrt(dist);

														if (dist < arr[i]) {
                                arr[i] = dist;
                            }

                            if (arr[i] < min) {
                                min = arr[i];
                                min_index = i;
                            }
                        }
                    }
                    sum += arr[min_index];
                    arr[min_index] = -1; //add the shortest distance node to the MST by marking it
										min = n*n; // reset min
                }
            }
            // else if (dim == 3) {
            //     float min = 3;
            //     float point[][] = new float[n][dim]; // matrix for all of your points
						//
            //     // generate point for arr[0] - arbitrary point
            //     int min_index = 0;
            //     for (int j = 1; j < n; j++) { //first populate this area with a value larger than possible generated from RNG
            //         arr[j] = 3;
            //         point[j][0] = rand.nextFloat();
            //         point[j][1] = rand.nextFloat();
            //         point[j][2] = rand.nextFloat();
            //     }
            //     arr[0] = 0;
            //     for (int j = 0; j < n; j++){
            //         for (int i = 0; i < n; i++) {
            //             if (arr[i] >= 0) {
            //                 float dist = (float) Math.sqrt((Math.pow((point[i][0] - point[min_index][0]),2) + Math.pow((point[i][1] - point[min_index][1]),2) + Math.pow((point[i][2] - point[min_index][2]),2)));
            //                 if (dist < arr[i]) {
            //                     arr[i] = dist;
            //                 }
						//
            //                 if (arr[i] < min) {
            //                     min = arr[i];
            //                     min_index = i;
            //                 }
            //             }
            //         }
            //         sum += arr[min_index];
            //         arr[min_index] = -1; //add the shortest distance node to the MST by marking it
            //     }
            // }
            // else if (dim == 4) {
            //     float min = 3;
            //     float point[][] = new float[n][dim]; // matrix for all of your points
						//
            //     int min_index = 0;
						//
            //     for (int j = 1; j < n; j++) { //first populate this area with a value larger than possible generated from RNG
            //         arr[j] = 3;
            //         point[j][0] = rand.nextFloat();
            //         point[j][1] = rand.nextFloat();
            //         point[j][2] = rand.nextFloat();
            //         point[j][3] = rand.nextFloat();
            //     }
            //     arr[0] = 0;
            //     for (int j = 0; j < n; j++){
            //         for (int i = 0; i < n; i++) {
            //             if (arr[i] >= 0) {
            //                 float dist = (float) Math.sqrt((Math.pow((point[i][0] - point[min_index][0]),2) + Math.pow((point[i][1] - point[min_index][1]),2) + Math.pow((point[i][2] - point[min_index][2]),2) + Math.pow((point[i][3] - point[min_index][3]),2)));
						//
            //                 if (dist < arr[i]) {
            //                     arr[i] = dist;
            //                 }
						//
            //                 if (arr[i] < min) {
            //                     min = arr[i];
            //                     min_index = i;
            //                 }
            //             }
            //         }
            //         sum += arr[min_index];
            //         arr[min_index] = -1; //add the shortest distance node to the MST by marking it
            //     }
            // }
						System.out.println(sum);
            total_sum += sum;
						System.out.println("Time: " + (System.nanoTime() - startTime)/Math.pow(10,9) + "sec");
						startTime = System.nanoTime();
        }

        System.out.println("Average: " + total_sum / times);

        /**if (bool == 1){
            System.out.println("Total time: " + (System.nanoTime() - startTime)/Math.pow(10,9) + "sec");
        }*/
    }
}
