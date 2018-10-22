package homeworks.assignment_2;

public class Task_8 {

    public static void main(String[] args) {

        int x1, x2, y1, y2, z1, z2;

        x1 = 1; x2 = 1; y1 = 1; y2 = 7; z1 = 4; z2 = 1;

        double distance_1,distance_2, distance_3;

        distance_1 = Math.sqrt(Math.pow(Math.abs(y2 - z2),2) + Math.pow(Math.abs(y1 - z1),2));
        distance_2 = Math.sqrt(Math.pow(Math.abs(y2 - x2),2) + Math.pow(Math.abs(y1 - x1),2));
        distance_3 = Math.sqrt(Math.pow(Math.abs(x2 - z2),2) + Math.pow(Math.abs(x1 - z1),2));

        double hypotenuse = Math.max(distance_1, Math.max(distance_2, distance_3));

        System.out.println("The distances calculated: " + distance_1 + " || " + distance_2 + " || "
                                                        + distance_3);
        System.out.println("The hypotenuse: " + hypotenuse);

        if (Math.abs((Math.pow(hypotenuse,2) - (Math.pow(distance_1,2) + Math.pow(distance_2,2)))) < 0.001) {
            System.out.println("The triangular is special & the hypotenuse is between X(x1,x2) and Z(z1,z2)");
        }
        else if (Math.abs((Math.pow(hypotenuse,2) - (Math.pow(distance_2,2) + Math.pow(distance_3,2)))) < 0.001) {
            System.out.println("The triangular is special & the hypotenuse is between Y(y1,y2) and Z(z1,z2)");
        }
        else if (Math.abs((Math.pow(hypotenuse,2) - (Math.pow(distance_1,2) + Math.pow(distance_3,2)))) < 0.001) {
            System.out.println("The triangular is special & the hypotenuse is between Y(y1,y2) and X(x1,x2)");
        }
        else System.out.println("The triangular is not a special one");

    }
}
