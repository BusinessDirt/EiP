import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class BookTest {

    @TestFactory
    @DisplayName("Test ISBN 10 and 13 validation")
    Stream<DynamicTest> validateIsbnTest() throws IllegalISBNException, IllegalAccessException {
        Book tester = new Book("none", "0123456789");
        String[] validIsbn = new String[] { "0123456789", "123456789x", "123456789X", "9780123456789", "9784563219870" };
        String[] invalidIsbn = new String[] { "123", "123456789x3", "AB3456789X", "7890123456789", "97801234567Z9" };
        String[] data = concat(validIsbn, invalidIsbn);

        return Arrays.stream(data).map(entry -> {
            boolean valid = Arrays.asList(validIsbn).contains(entry);
            if (valid) return dynamicTest(entry + " should not throw an Exception", () -> assertEquals(entry, tester.setIsbn(entry)));
            return dynamicTest(entry + " should throw an Exception", () -> assertThrows(IllegalISBNException.class, () -> tester.setIsbn(entry)));
        });
    }

    static String[] concat(String[] array1, String[] array2) {
        return Stream.concat(Arrays.stream(array1), Arrays.stream(array2))
                .toArray(size -> (String[]) Array.newInstance(array1.getClass().getComponentType(), size));
    }
}