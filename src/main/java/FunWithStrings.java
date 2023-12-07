import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FunWithStrings {

    public static int countWords(String text) {
        text = text.trim();
        if (text.isEmpty()) return 0;
        return (int) text.codePoints().filter(ch -> ch == ' ').count() + 1;
    }

    public static String getQuotedText(String text) {
        Pattern pattern = Pattern.compile("(\".*\")");
        Matcher m = pattern.matcher(text);
        if (m.find()) return m.group(1).replaceAll("\"", "");
        return null;
    }

    public static String commonPrefix(String text1, String text2) {
        int prefixLength = 0;
        for (int i = 0; i < Math.min(text1.length(), text2.length()); i++) {
            if (text1.charAt(i) == text2.charAt(i)) prefixLength++;
            else break;
        }
        return prefixLength == 0 ? "" : text1.substring(0, prefixLength);
    }
}
