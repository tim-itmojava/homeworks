package assignment_6.datatypes;

import java.util.Scanner;
import java.lang.String;

public class WorkingWithConsole {

    static void stringDataParser(String inputString) {

        if (inputString.contains(".")) {

            try {
                double doubleOutput = Double.parseDouble(inputString); // ClassCastException
                System.out.print("This is a double-formatted number doubled: " + doubleOutput * 2);

            } catch (ClassCastException | NumberFormatException e) {

              simpleStringOutput(inputString);

            }
        }

        else if (inputString.length() <= 6 && isOfDigits(inputString)) {

            if (Integer.parseInt(inputString) >= 0 && Integer.parseInt(inputString) <= 128) {
                System.out.println("This is a short-formatted number doubled: " + 2*Integer.parseInt(inputString));
            }
            else simpleStringOutput(inputString);
        }

        else {
            System.out.println("***** Whatever else required for the parser to support *****");
        }
    }

    static void simpleStringOutput(String inString) {
        System.out.println("All we can do is just print the input out: " + inString);
    }

    static boolean isOfDigits(String inString) {

        int charNumber = 0;

        do {
            compareWithUnicode(inString.charAt(charNumber));
            System.out.println("\\u" + Integer.toHexString(inString.charAt(charNumber) | 0x10000));
            charNumber++;
        }
        while(compareWithUnicode(inString.charAt(charNumber - 1)) && charNumber <= (inString.length() - 1));

        return (inString.length() - 1) == charNumber - 1;
    }

    static boolean compareWithUnicode(char aChar) {
        return
                Integer.toHexString(aChar | 0x10000).equals("10030") ||
                Integer.toHexString(aChar | 0x10000).equals("10031") ||
                Integer.toHexString(aChar | 0x10000).equals("10032") ||
                Integer.toHexString(aChar | 0x10000).equals("10033") ||
                Integer.toHexString(aChar | 0x10000).equals("10034") ||
                Integer.toHexString(aChar | 0x10000).equals("10035") ||
                Integer.toHexString(aChar | 0x10000).equals("10036") ||
                Integer.toHexString(aChar | 0x10000).equals("10037") ||
                Integer.toHexString(aChar | 0x10000).equals("10038") ||
                Integer.toHexString(aChar | 0x10000).equals("10039");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные в строчном формате");

        StringBuilder stringCompounded = new StringBuilder();
        String inputString;

        do {

            inputString = scanner.nextLine();
            stringCompounded.append(inputString);

        }
        while (!inputString.equals("exit"));

        stringCompounded.delete(stringCompounded.toString().length() - 4,stringCompounded.toString().length());
        String resultString = stringCompounded.toString();

        System.out.println("The raw input data looks like the following: " + resultString);

        stringDataParser(resultString);

    }
}
