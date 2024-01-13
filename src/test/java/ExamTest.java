import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ExamTest {

    public static Exam exam;

    @BeforeAll
    static void setup() {
        exam = new Exam("Einführung in die Programmierung 2023", 2023);
    }

    @Test
    @Order(1)
    void load() {
        exam.load();
        System.out.println(exam);
    }

    @Test
    @Order(2)
    void save() {
        if (!Objects.equals(exam.getQuestions().get(exam.getNumberOfQuestions() - 1).text(), "Test Question?"))
            exam.addQuestion("Test Question?", 7);
        exam.save();
    }
}