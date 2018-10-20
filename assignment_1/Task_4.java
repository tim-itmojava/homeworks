package assignment_1;

import java.util.Scanner;

public class Task_4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double m = 0.0D, n = 0.0D;

        while (true) {

            System.out.println("Please enter the first number M in the following format - (xx.yy) or 9.9 to quit");

            try {
                m = scanner.nextDouble();

            } catch (Exception e) {
                e.printStackTrace();
            }

            if (m == 9.9) break;

            System.out.println("Please enter the second number N in the following format - (xx.yy) or 9.9 to quit");
            try {
                n = scanner.nextDouble();
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (n == 9.9) break;

            // checking which number is closer to 10

            if (m >= 0.0D && n >= 0.0D || m < 0.0D && n < 0.0D) {       // --> checking if both positive or negative
                if (Math.abs(10 - m) > Math.abs(10 - n)) {
                    System.out.println("N = " + n + " is closer to 10");
                } else if (Math.abs(10 - m) < Math.abs(10 - n)) {
                    System.out.println("M = " + m + " is closer to 10");
                } else System.out.println("M & N are equal and hence at the same distance from 10: [" +
                        Math.abs(10 - n) + "]");

            } else if (m >= 0.0D && n <= 0.0D) {     // --> checking if M positive && N negative
                if (Math.abs(10 - m) > (10 - n)) {
                    System.out.println("N = " + n + " is closer to 10");
                } else if (Math.abs(10 - m) < (10 - n)) {
                    System.out.println("M = " + m + " is closer to 10");
                } else System.out.println("M & N are at the same distance from 10: [" + (10 - n) + "]");
            }
            else if (n >= 0.0D && m <= 0.0D) {
                if (Math.abs(10 - n) > (10 - m)) {
                    System.out.println("M = " + m + " is closer to 10");
                }
                else if (Math.abs(10 - n) < (10 - m)) {
                    System.out.println("N = " + n + " is closer to 10");
                } else System.out.println("M & N are at the same distance from 10: [" + (10 - m) + "]");
            }
        }
    }
}