package assignement_4;

import java.util.Arrays;

public class Task_1 {

    public static void main(String[] args) {

        int[] A = {1,1};
        int[] B = {1,7};
        int[] C = {4,1};

        Triangle triangle = new Triangle(A,B,C);

        System.out.println("The square of the triangle = " + triangle.getSquare(triangle));

    }
}

class Triangle {

    private int[] A = {0, 0};
    private int[] B = {0, 0};
    private int[] C = {0, 0};


    public Triangle(int[] aA, int[] aB, int[] aC) {

        if (aA[0] >= 0 && aA[1] >= 0 && aB[0] >= 0 && aB[1] >= 0 && aC[0] >= 0 & aC[1] >= 0) {

            this.A = aA.clone();

            // System.out.println(Arrays.toString(this.A));

            this.B = aB.clone();
            this.C = aC.clone();

            System.out.println(Arrays.toString(A) + " || " + Arrays.toString(B) + " || " + Arrays.toString(C));
        }
    }

    public int[] getA() {
        return A;
    }

    public int[] getB() {
        return B;
    }

    public int[] getC() {
        return C;
    }

    public double getSquare (Triangle aTriangle) {

         double distance_1,distance_2, distance_3;

        distance_1 = Math.sqrt(Math.pow(Math.abs(aTriangle.getB()[1] - aTriangle.getC()[1]),2) + Math.pow(Math.abs(aTriangle.getB()[0] - aTriangle.getC()[0]),2));     // b-side
        distance_2 = Math.sqrt(Math.pow(Math.abs(aTriangle.getB()[1] - aTriangle.getA()[1]),2) + Math.pow(Math.abs(aTriangle.getB()[0] - aTriangle.getA()[0]),2));     // a-side
        distance_3 = Math.sqrt(Math.pow(Math.abs(aTriangle.getA()[1] - aTriangle.getC()[1]),2) + Math.pow(Math.abs(aTriangle.getA()[0] - aTriangle.getC()[0]),2));     // c-side
        double p = 0.5*(distance_1 + distance_2 + distance_3);
        System.out.println("Distances: " + distance_1 + " || " + distance_2 + " || " + distance_3);

        return Math.sqrt(p * (p - distance_1) * (p - distance_2) * (p - distance_3));
    }
}
