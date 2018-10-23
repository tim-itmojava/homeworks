package assignment_3;

import java.util.Scanner;

public class Task_6 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String originalString = new String();

        while (true) {

            System.out.println("Please enter a string of up to 140 symbols");

            try {
                originalString = scanner.next();


            }
            catch (Exception e) {

                e.printStackTrace();
            }
            finally {
                System.out.println("Number of symbols entered: " + originalString.length());
            }
            if (originalString.length() <= 140) break;

        }

        String toBeReplacedString = new String();
        while (true) {

            System.out.println("Please enter a substring to be replaced");

            try {
                toBeReplacedString = scanner.next();
            }
            catch (Exception e) {

                e.printStackTrace();
            }

            if (originalString.contains(toBeReplacedString)) {break;}
        }

        String replacementString = new String();

        while (true) {

            System.out.println("Please enter a substitute substring");

            try {
                replacementString = scanner.next();
            }
            catch (Exception e) {

                e.printStackTrace();
            }

            if (originalString.length() - toBeReplacedString.length() + replacementString.length() <= 140) break;

        }

        System.out.println("Original String: " + originalString);
        System.out.println("To be replaced String: " + toBeReplacedString);
        System.out.println("Replacement String: " + replacementString);

        originalString = originalString.replace(toBeReplacedString, replacementString);
        System.out.println(originalString);

//        StringBuilder modifiedString = new StringBuilder();
//        modifiedString.append(originalString);
//        modifiedString.toString().replace(toBeReplacedString,replacementString);
//        System.out.println(modifiedString);

    }
}
