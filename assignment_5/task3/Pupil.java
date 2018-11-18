package assignment_5.task3;

public class Pupil {

    private int id;
    private ExamResults[] examResults;

    public Pupil(int id) {
        this.id = id;
        System.out.println("initiating a pupil...");
    }

    private class ExamResults {
        String examLabel;
        String examStatus;

        private ExamResults(String examLabel, int mark) {
            this.examLabel = examLabel;
            this.examStatus = markDecision(mark);
        }

        private String markDecision(int mark) {

            if (mark >=3)
                return "passed";
            else
                return "failed";
        }

        private String getExamLabel() {
            return examLabel;
        }

        private String getExStatus() {
            return examStatus;
        }
    }

    public void setExams (String[] exam, int[] marks) {

//        System.out.println("ExamResults variable before creating a new object: " + this.examResults);

        this.examResults = new ExamResults[exam.length];

//        System.out.println("ExamResults variable after creating a new object: " + this.examResults);

        for (int i = 0; i < exam.length; i++) {
            this.examResults[i] = new ExamResults(exam[i], marks[i]);

        }
    }

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();
        msg.append("Pupil: ").append(id).append(": ");
        for (int i = 0; i < this.examResults.length; i++) {
            msg.append(examResults[i].getExamLabel()).append(" ").append(examResults[i].getExStatus()).append(" || ");
        }

        return msg.toString();
    }
}
