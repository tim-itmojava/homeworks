package assignment_2;

/* looking for a symmetry around the clock
by STR, 21/10/2018
**/

public class Task_7 {

    public static void main(String[] args) {

// we'll define each digit comprising the clock displayed time as a separate variable with its suffix reflecting the position held
// and then run nested loops catering for proper thresholds for number of hours/minutes

        int symmertyCounter = 0;

        for (int digit_1 = 0; digit_1 <= 2; digit_1++) {

            if (digit_1 == 0) {
                for (int digit_2 = 0; digit_2 <= 9; digit_2++) {
                    for (int digit_3 = 0; digit_3 <= 5; digit_3++) {
                        for (int digit_4 = 0; digit_4 <= 9; digit_4++) {

                            if (digit_1 == digit_4 && digit_2 == digit_3) {

                                symmertyCounter++;
                                System.out.println("clock: " + digit_1 + "" + digit_2 + ":" + digit_3 + "" + digit_4);
                            }



                        }
                    }
                }
            }
            else if (digit_1 == 1) {
                for (int digit_2 = 0; digit_2 <= 9; digit_2++) {
                    for (int digit_3 = 0; digit_3 <= 5; digit_3++) {
                        for (int digit_4 = 0; digit_4 <= 9; digit_4++) {

                            if (digit_1 == digit_4 && digit_2 == digit_3) {

                                symmertyCounter++;
                                System.out.println("clock: " + digit_1 + "" + digit_2 + ":" + digit_3 + "" + digit_4);
                            }


                        }
                    }
                }
            }
            else {
                for (int digit_2 = 0; digit_2 <= 3; digit_2++) {
                    for (int digit_3 = 0; digit_3 <= 5; digit_3++) {
                        for (int digit_4 = 0; digit_4 <= 9; digit_4++) {

                            if (digit_1 == digit_4 && digit_2 == digit_3) {

                                symmertyCounter++;
                                System.out.println("clock: " + digit_1 + "" + digit_2 + ":" + digit_3 + "" + digit_4);
                            }


                        }
                    }
                }
            }

        }

        System.out.println("Symmetric indication displayed throughout a day = " + symmertyCounter);
    }
}