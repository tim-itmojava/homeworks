package assignment_6.designclasses.bodymass;

import java.sql.SQLTransactionRollbackException;

public class Body {

    protected enum BodyType { UNDERWEIGHT, NORMAL, OVERWEIGHT, OBESITY }
    protected enum RelationType { LESS_THAN, BETWEEN, MORE_THAN }

    protected static double[] thresholds = { 18.5, 24.9, 29.9, 30 };

    protected static void massIndex(int weight, int height) {

        double massIndexValue = weight/(height*height/1e4);
        String bodyType;

        if (massIndexValue < thresholds[0]) {
            bodyType = String.valueOf(BodyType.UNDERWEIGHT);
            printOutResult(bodyType, massIndexValue);
        }
        else if (massIndexValue <= thresholds[1]) {
            bodyType = String.valueOf(BodyType.NORMAL);
            printOutResult(bodyType, massIndexValue);
        }
        else if (massIndexValue <= thresholds[2]) {
            bodyType = String.valueOf(BodyType.OVERWEIGHT);
            printOutResult(bodyType, massIndexValue);
        }
        else if (massIndexValue > thresholds[3]) {
            bodyType = String.valueOf(BodyType.OBESITY);
            printOutResult(bodyType, massIndexValue);
        }
    }

    protected static void printOutResult(String bodyType, double massIndexValue) {

        if (bodyType.equals(String.valueOf(BodyType.UNDERWEIGHT))) {
            System.out.println(bodyType + " : " + RelationType.LESS_THAN + " " + thresholds[0]);
        }

        if (bodyType.equals(String.valueOf(BodyType.NORMAL))) {
            System.out.println(bodyType + " : " + RelationType.BETWEEN + " " + thresholds[1] + " and " + thresholds[2]);
        }

        if (bodyType.equals(String.valueOf(BodyType.OVERWEIGHT))) {
            System.out.println(bodyType + " : " + RelationType.BETWEEN + " " + thresholds[2] + " and " + thresholds[3]);
        }

        if (bodyType.equals(String.valueOf(BodyType.OBESITY))) {
            System.out.println(bodyType + " : " + RelationType.MORE_THAN + " " + thresholds[3]);
        }
    }

    public static void main(String[] args) {

        Body.massIndex(90,175);
        Body.massIndex(58,168);

    }
}
