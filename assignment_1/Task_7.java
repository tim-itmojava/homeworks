package assignment_1;

import java.util.Scanner;

public class Task_7 {

    public static void main(String[] args) {

        double coef_a = 0.0D;
        double coef_b = 0.0D;
        double coef_c = 0.0D;
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Please enter coefficient A of the square equation in the following format - (xx.yy) or 9.9 to quit");

            try {
                coef_a = scanner.nextDouble();

            } catch (Exception e) {
                e.printStackTrace();
            }

            if (coef_a == 9.9) break;

            System.out.println("Please enter coefficient B of the square equation in the following format - (xx.yy) or 9.9 to quit");
            try {
                coef_b = scanner.nextDouble();
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (coef_b == 9.9) break;

            System.out.println("Please enter coefficient C of the square equation in the following format - (xx.yy) or 9.9 to quit");
            try {
                coef_c = scanner.nextDouble();
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (coef_c == 9.9) break;


            double disciminant = Math.pow(coef_b, 2) - 4 * coef_a * coef_c;
            System.out.println("Discriminant = " + disciminant + " || " + "Square root out of discriminant = " + Math.sqrt(disciminant));

            if (disciminant < 0) {
                System.out.println("The equation does not have a single solution");
            } else if (disciminant == 0) {
                System.out.println("The equation has only one solution, and the root is = " +
                        ((-1)*coef_b / (2 * coef_a)));
            } else {
                System.out.println("There are two roots satisfying the equation");
                System.out.println("Root 1 = " + ((-1)*coef_b + Math.sqrt(disciminant)) / (2 * coef_a));
                System.out.println("Root 2 = " + ((-1)*coef_b - Math.sqrt(disciminant)) / (2 * coef_a));
            }
        }
    }
}
