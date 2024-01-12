import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Exam {

    private final String name;
    private final int year;
    private final List<Question> questions;

    public Exam(String name, int year) {
        this.name = name;
        this.year = year;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(String text, int points) {
        this.questions.add(new Question(text, points));
    }

    public int getNumberOfQuestions() {
        return this.questions.size();
    }

    public int getSumOfPoints() {
        return this.questions.stream().mapToInt(Question::points).sum();
    }

    public void orderQuestionsByLength() {
        this.questions.sort((o1, o2) -> Integer.compare(o2.text().length(), o1.text().length()));
    }

    public void orderQuestionsByPoints() {
        this.questions.sort((o1, o2) -> Integer.compare(o2.points(), o1.points()));
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(this.getName());
        sb.append("(").append(this.getYear()).append(")\n");
        for (Question q : this.getQuestions()) {
            sb.append(q).append("\n");
        }
        return sb.toString();
    }
}
