package assignment_2;

/*
a code to print out a sequence of powers of 2
by STR, 21/10/2018
**/

public class Task_3 {

    public static void main(String[] args) {

        for (int j=1; j<=20; j+=1) {
            System.out.println("count(" + j + ") = " + Math.pow(2,j));
        }
    }

}
