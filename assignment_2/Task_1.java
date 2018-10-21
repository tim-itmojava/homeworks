package assignment_2;

public class Task_1 {

    public static void main(String[] args) {

        // test ranking with the data supplied out of my head
        Ranking toRank0 = new Ranking(-5.0,-10,7);
        toRank0.getRanking(toRank0);


        // the following is as per the task to be solved
        Ranking toRank1 = new Ranking(3,9,-1);
        toRank1.getRanking(toRank1);

        Ranking toRank2 = new Ranking(2,4,3);
        toRank2.getRanking(toRank2);

        Ranking toRank3 = new Ranking(7,0,-5);
        toRank3.getRanking(toRank3);

    }
}

class Ranking {

    private double a, b, c;

    Ranking (double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void getRanking(Ranking inputData) {
        
        if (inputData.a==Math.max(Math.max(inputData.a,inputData.b),Math.max(inputData.b,inputData.c))) {
            if (inputData.b > inputData.c) {
                System.out.println(inputData.c + " " + inputData.b + " " + inputData.a);
            }
            else {System.out.println(inputData.b + " " + inputData.c + " " + inputData.a);}

        } else if(inputData.b == Math.max(Math.max(inputData.a,inputData.b),Math.max(inputData.b,inputData.c))) {
            if (inputData.a > inputData.c) {
                System.out.println(inputData.c + " " + inputData.a + " " + inputData.b);
            }
            else {System.out.println(inputData.a + " " + inputData.c + " " + inputData.b);}
        }

        else {
            if (inputData.a > inputData.b) {
                System.out.println(inputData.b + " " + inputData.a + " " + inputData.c);
            }
            else {System.out.println(inputData.a + " " + inputData.b + " " + inputData.c);}
        }
    }
}
