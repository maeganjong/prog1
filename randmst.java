import java.io.*;
import java.util.Random;
import java.lang.Math;

public class randmst{
	public static void main (String[] args) {
        // args[0] - 0, args[1] - numpoints, args[2] - numtrials, args[3] - dimension
        // flag is for time or no time
        // FOR LOOP FOR NUM TRIALS

        int n = Integer.parseInt(args[1]);
        int dim = Integer.parseInt(args[3]);
        float arr[] = new float[n];
        float sum = 0;

        Random rand = new Random();
		long seed = System.currentTimeMillis() % 1000; //define to something random
		rand.setSeed(seed);

        if (dim == 0) { // for the 0th dimension
            float min = 2;
            int min_index = 0;
            for (int j = 0; j < n; j++) { //first populate this area with a value larger than possible generated from RNG
                arr[j] = 2;
            }

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
        else if (dim == 2) {
            float min = 3;
            float point[][] = new float[n][dim]; // matrix for all of your points

            // generate point for arr[0] - arbitrary point
            point[0][0] = rand.nextFloat();
            point[0][1] = rand.nextFloat();

            int min_index = 0;
            arr[0] = 0;

            for (int j = 1; j < n; j++) { //first populate this area with a value larger than possible generated from RNG
                arr[j] = 3;
            }

            for (int j = 0; j < n; j++){
                for (int i = 0; i < n; i++) {
                    if (arr[i] >= 0) {
                        float v1 = rand.nextFloat();
                        float v2 = rand.nextFloat();

                        float dist = Math.sqrt((Math.pow((v1 - point[min_index][0]),2) + Math.pow((v2 - point[min_index][1]),2)));
                        if (dist < arr[i]) {
                            arr[i] = dist;
                            point[i][0] = v1;
                            point[i][1] = v2;
                        }

                        if (arr[i] < min) {
                            min = arr[i];
                            min_index = i;
                        }
                    }
                }
                sum += arr[min_index];
                arr[min_index] = -1; //add the shortest distance node to the MST by marking it
            }
        }
        else if (dim == 3) {
            float min = 3;
            float point[][] = new float[n][dim]; // matrix for all of your points

            // generate point for arr[0] - arbitrary point
            point[0][0] = rand.nextFloat();
            point[0][1] = rand.nextFloat();
            point[0][2] = rand.nextFloat();

            int min_index = 0;
            arr[0] = 0;

            for (int j = 1; j < n; j++) { //first populate this area with a value larger than possible generated from RNG
                arr[j] = 3;
            }

            for (int j = 0; j < n; j++){
                for (int i = 0; i < n; i++) {
                    if (arr[i] >= 0) {
                        float v1 = rand.nextFloat();
                        float v2 = rand.nextFloat();
                        float v3 = rand.nextFloat();

                        float dist = Math.sqrt((Math.pow((v1 - point[min_index][0]),2) + Math.pow((v2 - point[min_index][1]),2) + Math.pow((v3 - point[min_index][2]),2)));
                        if (dist < arr[i]) {
                            arr[i] = dist;
                            point[i][0] = v1;
                            point[i][1] = v2;
                            point[i][2] = v3;
                        }

                        if (arr[i] < min) {
                            min = arr[i];
                            min_index = i;
                        }
                    }
                }
                sum += arr[min_index];
                arr[min_index] = -1; //add the shortest distance node to the MST by marking it
            }
        }
        else if (dim == 4) {
            float min = 3;
            float point[][] = new float[n][dim]; // matrix for all of your points

            // generate point for arr[0] - arbitrary point
            point[0][0] = rand.nextFloat();
            point[0][1] = rand.nextFloat();
            point[0][2] = rand.nextFloat();
            point[0][3] = rand.nextFloat();

            int min_index = 0;
            arr[0] = 0;

            for (int j = 1; j < n; j++) { //first populate this area with a value larger than possible generated from RNG
                arr[j] = 3;
            }

            for (int j = 0; j < n; j++){
                for (int i = 0; i < n; i++) {
                    if (arr[i] >= 0) {
                        float v1 = rand.nextFloat();
                        float v2 = rand.nextFloat();
                        float v3 = rand.nextFloat();
                        float v4 = rand.nextFloat();

                        float dist = Math.sqrt((Math.pow((v1 - point[min_index][0]),2) + Math.pow((v2 - point[min_index][1]),2) + Math.pow((v3 - point[min_index][2]),2) + Math.pow((v4 - point[min_index][3]),2)));
                        
                        if (dist < arr[i]) {
                            arr[i] = dist;
                            point[i][0] = v1;
                            point[i][1] = v2;
                            point[i][2] = v3;
                            point[i][3] = v4;
                        }

                        if (arr[i] < min) {
                            min = arr[i];
                            min_index = i;
                        }
                    }
                }
                sum += arr[min_index];
                arr[min_index] = -1; //add the shortest distance node to the MST by marking it
            }
        }

        System.out.println(sum);

    }
}
