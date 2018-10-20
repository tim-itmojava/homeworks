package assignment_1;

import java.util.Scanner;

public class Task_5 {

    public static void main(String[] args) {

        double interestRate = 0.0D;
        double mortgageRequested = 0.0D;
        int years = 0, months = 0;

        double annuityPayment = 0.0D;
        double monthlyRate = 0.0D;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the amount of Mortgage requested: ");
        mortgageRequested = scanner.nextDouble();

        System.out.println("Please enter the annual interest rate: ");
        interestRate = scanner.nextDouble();

        System.out.println("Please enter the number of years the mortgage is to be calculated for");
        years = scanner.nextInt();

        monthlyRate = interestRate/(100*12);
        months = years*12;

        System.out.println(mortgageRequested + "||" + monthlyRate + "||" + months);

        annuityPayment = (monthlyRate*mortgageRequested)/((1 - Math.pow(1 + monthlyRate,(-1)*months)));
        System.out.println("Annuity payment calculated = " + annuityPayment);

        System.out.println("Gross payment over the whole mortgage period = " + annuityPayment*months);
        System.out.println("Accumulated interest to be paid over the whole period = " + (annuityPayment*months - mortgageRequested));

    }
}
