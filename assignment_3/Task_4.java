package assignment_3;

import java.util.Arrays;
import java.util.Scanner;

public class Task_4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int dimArray = 0;

        while (true) {

            System.out.println("Please enter an even number of array elements: ");

            try {
                dimArray = scanner.nextInt();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            if (dimArray%2 == 0) break;

        }

            int[] rndArray = new int[dimArray];

            for (int index = 0; index <= dimArray - 1; index++) {
                rndArray[index] = (int) Math.round(Math.random() * 10 - 5);
            }

            System.out.println(Arrays.toString(rndArray));

            int[] rndArray1 = Arrays.copyOfRange(rndArray,0,dimArray/2);
            int[] rndArray2 = Arrays.copyOfRange(rndArray, dimArray/2, rndArray.length);

            System.out.println("Array_1 (left part): " + Arrays.toString(rndArray1)); // displaying the array generated
            System.out.println("Array_2 (right part): " + Arrays.toString(rndArray2)); // displaying the array generated

            int sum1, sum2;
            sum1 = sum2 = 0;

            for (int index = 0; index <= dimArray/2 - 1; index++) {
                sum1 = sum1 + Math.abs(rndArray1[index]);
                sum2 = sum2 + Math.abs(rndArray2[index]);
            }

            if (sum1 == sum2) { System.out.println("The modules are equal and the value of MOD is " + sum1); }
            else if (sum1 > sum2) {
                System.out.println("The MOD of Array_1: " + sum1 + " supersedes the same metrics for Array_2: " + sum2);
            }
            else System.out.println("The MOD of Array_2: " + sum2 + " supersedes the same metrics for Array_1: " + sum1);

            System.out.println();

    }
}
