public class ExamApplication {

    public static void main(String[] args) {
        Exam exam = new Exam("exam1", 2023);
        exam.addQuestion("question2?", 5);
        exam.addQuestion("question1", 10);
    }
}
