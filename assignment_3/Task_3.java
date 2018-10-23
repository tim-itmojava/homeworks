package assignment_3;

import java.util.ArrayList;
import java.util.Arrays;

public class Task_3 {

    public static void main(String[] args) {

        int[] rndArray = new int[14];
        int oddNum = 0, evenNum = 0;

        for (int i = 0; i < rndArray.length; i++) {

            rndArray[i] = (int) Math.round(Math.random()*9);

            if (rndArray[i]%2 == 0 && rndArray[i] != 0) {
                evenNum++;
            }
            else if (rndArray[i] != 0) oddNum++;

            System.out.println("Random Number[" + i + "] = " + rndArray[i]);
        }
        
        System.out.println(Arrays.toString(rndArray));
        System.out.println("Even numbers generated: " + evenNum);

        System.out.println("Odd numbers generated: " + oddNum);

        System.out.println("Naughts generated: " + (rndArray.length - evenNum - oddNum));

    }
}
