package assignment_2;

import java.util.Scanner;

/*
checking if a natural number is a simple number, i.e. no remainder appears only is it's divided on itself or "1"
by STR, 21/10/2018
**/
public class Task_4 {

    public static void main(String[] args) {

        Boolean typeinOK = false;
        int number = 0;
        int counter = 0;

        System.out.println("Please enter a number to be checked against being a Prime. Alternatively, enter 0 to quit: ");

        do {
            Scanner typeIn = new Scanner(System.in);
            int in = typeIn.nextInt();
            if (in > 0) typeinOK = true;
            number = in;
            if (number==0) System.exit(10);
        }
        while (!typeinOK);


        for (int i = 2; i < number; i++) {

            if (number%i  == 0) counter++;

        }

        if (counter > 0) System.out.println("The number entered is not Prime");
        else System.out.println("The number entered is Prime");

    }

}
