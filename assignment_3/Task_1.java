package assignment_3;

public class Task_1 {

    public static void main(String[] args) {

        int lowValue = 2;
        int highValue = 20;

        int numbrOfElements = (highValue - lowValue)/2 + 1;

        int[] myArray = new int[numbrOfElements];

        for (int i =0; i < numbrOfElements; i++) {
            myArray[i] = 2 + i*2;
        }

        System.out.println("The array elements printed out in line: ");
        for (int i =0; i < numbrOfElements; i++) {
            System.out.print(myArray[i] + " ");
        }
        System.out.println();
        System.out.println("The array elements printed out in column:");
        for (int i =0; i < numbrOfElements; i++) {
            System.out.println(myArray[i]);
        }
    }
}
