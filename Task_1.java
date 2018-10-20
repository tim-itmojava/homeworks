package assignment_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Task_1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList dims = new ArrayList();

        Dimension dimension_1 = new Dimension("length",0.0);
        Dimension dimension_2 = new Dimension("width",0.0);
        Dimension dimension_3 = new Dimension("height",0.0);

        dims.add(0,dimension_1);
        dims.add(1,dimension_2);
        dims.add(2,dimension_3);

        int i = 0; double metrics;

        while (i < dims.size()) {

            Dimension temp = (Dimension) dims.get(i);
            System.out.println("Please enter the " + temp.getDimensionName() + " of the figure in cm (xx.yy cm):");

            try {
                metrics = scanner.nextDouble();
                temp.setDimensionValue(metrics);
                System.out.println("dimension_1 " + dimension_1.getDimensionValue());
                System.out.println("dimension_2 " + dimension_2.getDimensionValue());
                System.out.println("dimension_3 " + dimension_3.getDimensionValue());
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            i++;
        }

        System.out.println("The total square of the figure surface is " +
                                2*(dimension_1.getDimensionValue() * dimension_2.getDimensionValue() +
                                dimension_2.getDimensionValue() * dimension_3.getDimensionValue() +
                                dimension_1.getDimensionValue() * dimension_3.getDimensionValue()) + " m2"
                );
    }
}

    class Dimension {

    private String dimensionName;
    private Double dimensionValue;


        public Dimension(String dimensionName, Double dimensionValue) {
            this.dimensionValue = dimensionValue;
            this.dimensionName = dimensionName;
        }

        public String getDimensionName() {
            return dimensionName;
        }

        public Double getDimensionValue() {
            return dimensionValue;
        }

        public void setDimensionValue(Double dimensionValue) {
            this.dimensionValue = dimensionValue;
        }
    }