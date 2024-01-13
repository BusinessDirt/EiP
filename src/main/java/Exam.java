import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Exam {

    private String name;
    private int year;
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

    public boolean load() {
        try {
            FileReader reader = new FileReader("./config.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            this.name = readFromBuffer(bufferedReader);
            this.year = Integer.parseInt(readFromBuffer(bufferedReader));
            this.questions.clear();
            int questions = Integer.parseInt(readFromBuffer(bufferedReader));
            for (int i = 0; i < questions; i++) {
                this.addQuestion(readFromBuffer(bufferedReader), Integer.parseInt(readFromBuffer(bufferedReader)));
            }

            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private String readFromBuffer(BufferedReader buffer) {
        try {
            if (buffer.ready()) return buffer.readLine();
            throw new IOException("BufferedReader is empty");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void save() {
        try (FileWriter writer = new FileWriter("./config.txt")) {
            writer.write(this.name + "\n");
            writer.write(this.year + "\n");
            writer.write(this.getNumberOfQuestions() + "\n");

            for(Question q : this.getQuestions()) {
                writer.write(q.text() + "\n");
                writer.write(q.points() + "\n");
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
