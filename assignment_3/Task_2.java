package assignment_3;

public class Task_2 {

    public static void main(String[] args) {

        int lowValue = 1;
        int highValue = 99;

        int numeberOfElements = (99 - 1)/2 + 1;

        System.out.println("Number of elements: " + numeberOfElements + " Division check: " + 1%2);
        int[] myArray = new int[numeberOfElements];

        int j = 0;

        for (int i = 1; i <= 99; i++) {

            if (i%2 != 0) {
                myArray[j] = i;
                System.out.print(myArray[j] + " ");
            j++;
            }

        }

        System.out.println();

        for (j = myArray.length - 1; j >= 0; j--) {
            System.out.print(myArray[j] + " ");
        }

    }

}
