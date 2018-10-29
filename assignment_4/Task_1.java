package assignment_4;

import java.util.Arrays;

public class Task_1 {

    public static void main(String[] args) {

        int[] A = {1,1};
        int[] B = {1,7};
        int[] C = {4,1};

        Triangle triangle = new Triangle(A,B,C);
        System.out.println("The square of the triangle = " + triangle.calculateSquare());

        System.out.println();

        Circle circle = new Circle(5);
        System.out.println("Circle created is of the following mertics: " +
                            circle.getRadius() +
                            " || " + circle.getRoundCircle());

        System.out.println();

        Rectangle rectangle = new Rectangle(5,7);

        System.out.println("The square of rectangle = " + rectangle.calculateSquare());

    }
}

class Triangle {

    private int[] A = {0, 0};
    private int[] B = {0, 0};
    private int[] C = {0, 0};


    public Triangle(int[] aA, int[] aB, int[] aC) {

        if (aA[0] >= 0 && aA[1] >= 0 && aB[0] >= 0 && aB[1] >= 0 && aC[0] >= 0 & aC[1] >= 0) {

            this.A = aA.clone();
            this.B = aB.clone();
            this.C = aC.clone();

            System.out.println(Arrays.toString(A) + " || " + Arrays.toString(B) + " || " + Arrays.toString(C));
        }
        else System.out.println("Improper value for radius has been provided. An object cannot be initialised");
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

    public double calculateSquare () {

         double distance_1,distance_2, distance_3;

        distance_1 = Math.sqrt(Math.pow(Math.abs(this.getB()[1] - this.getC()[1]),2) + Math.pow(Math.abs(this.getB()[0] - this.getC()[0]),2));     // b-side
        distance_2 = Math.sqrt(Math.pow(Math.abs(this.getB()[1] - this.getA()[1]),2) + Math.pow(Math.abs(this.getB()[0] - this.getA()[0]),2));     // a-side
        distance_3 = Math.sqrt(Math.pow(Math.abs(this.getA()[1] - this.getC()[1]),2) + Math.pow(Math.abs(this.getA()[0] - this.getC()[0]),2));     // c-side
        double p = 0.5*(distance_1 + distance_2 + distance_3);
        System.out.println("Distances: " + distance_1 + " || " + distance_2 + " || " + distance_3);

        return Math.sqrt(p * (p - distance_1) * (p - distance_2) * (p - distance_3));
    }
}

class Circle {

    private double radius;

    public Circle(double radius) {

        this.setRadius(radius);
    }

    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        }
        else {
            System.out.println("Improper value for radius has been provided. An object cannot be initialised");
        }
    }

    public double getRadius() {
        return this.radius;
    }

    public double getRoundCircle(){
        return 2 * Math.PI * this.radius;

    }
}

class Rectangle {

    private int sideA;
    private int sideB;

    public Rectangle(int sideA, int sideB) {

        if (sideA > 0 && sideB > 0) {
            this.sideA = sideA;
            this.sideB = sideB;

            System.out.println(this.sideA + "||" + this.sideB);
        }
    }

    public double calculateSquare() {
        return this.sideA*this.sideB;
    }
}
