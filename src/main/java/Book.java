import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Book {
    private final String title;
    private final String isbn;
    private static final Pattern validISBNPattern = Pattern.compile("(^\\d{9}(X|x|\\d)$)|(^(978)?\\d{10}$)");

    public Book(String title, String isbn) throws IllegalAccessException, IllegalISBNException {
        if (title == null || isbn == null) throw new IllegalAccessException();
        this.isbn = setIsbn(isbn);
        this.title = title;
    }

    protected String setIsbn(String isbn) throws IllegalISBNException {
        Matcher m = validISBNPattern.matcher(isbn);
        if (m.matches()) return isbn;
        if (isbn.length() == 10) throw new IllegalISBN10Exception("Laenge stimmt nicht für eine gueltige ISBN");
        if (isbn.length() == 13) {
            if (!isbn.startsWith("978")) throw new IllegalISBN13Exception("ISBN der Laenge 13 faengt nicht mit 978 an");
            throw new IllegalISBN13Exception("Laenge stimmt nicht für eine gueltige ISBN");
        }
        throw new IllegalISBNException("ISBN enthaelt ein ungueltiges Zeichen");
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }
}
