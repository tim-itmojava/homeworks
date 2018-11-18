package assignment_5.task3;

public class MainForPupil {

    public static void main(String[] args) {

        Pupil pupil1 = new Pupil(1324);

        String[] exam = { "Mathematics", "Biology" };
        int[] marks = { 3,2 };

        pupil1.setExams(exam, marks);

        System.out.println(pupil1);

    }
}
