package assignment_2;

/* Fibonacci sequence (F-sequence)
**/

public class Task_5 {

    public static void main(String[] args) {
        // to print out the first 11 members of the F-sequence

        long sqCurrent = 0;
        long sqOneStepAway = 0;
        long sqTwoStepsAway;

        for (int index=0; index<=11; index+=1) {

            switch(index) {
                case 0: {
                    sqCurrent = 0;
                    // System.out.println("The " + index + "-th member of the F-series is: " + sqCurrent); <- suppressing printing out the initial zero member of the sequence
                    break;
                }
                case 1: {
                    sqOneStepAway = sqCurrent;
                    sqCurrent = 1;
                    System.out.println("The " + index + "-th member of the F-series is: " + sqCurrent);
                    break;
                }
                default: {
                    sqTwoStepsAway = sqOneStepAway;
                    sqOneStepAway = sqCurrent;
                    sqCurrent = sqOneStepAway + sqTwoStepsAway;
                    System.out.println("The " + index + "-th member of the F-series is: " + sqCurrent);
                }
            }
        }

    }

}
