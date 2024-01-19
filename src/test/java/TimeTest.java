import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.*;

class TimeTest {

    @Test
    void testClone() {
        Time t1 = new Time(12, 34, 5);
        Time t2 = t1.clone();
        assertEquals(t1.getHours(), t2.getHours());
        assertEquals(t1.getMinutes(), t2.getMinutes());
        assertEquals(t1.getSeconds(), t2.getSeconds());
    }

    @Test
    void isEqualTo() {
        Time t1 = new Time(23, 14, 59);
        assertTrue(t1.isEqualTo(t1.clone()));
    }

    @Test
    void add() {
        Time t1 = new Time(11, 14, 59);
        Time t2 = new Time(22, 29, 58);
        Time t3 = new Time(9, 44, 57);
        t1.add(t1);
        assertTrue(t2.isEqualTo(t1));
        t1.add(new Time(11, 14, 59));
        assertTrue(t3.isEqualTo(t1));
    }

    @TestFactory
    @DisplayName("Calculating the difference between two times")
    Stream<DynamicTest> differenceTo() {
        int[][] data = new int[][] { { 12, 12, 12, 1, 1, 1, 12, 48, 49 }, { 3, 45, 42, 13, 14, 15, 9, 28, 33 }, { 25, 12, 3, 14, 14, 15, 14, 2, 12 }, { 23,  55, 4, 5, 23, 55, 5, 28, 51 } };
        return Arrays.stream(data).map(entry -> {
            Time from = new Time(entry[0], entry[1], entry[2]);
            Time to = new Time(entry[3], entry[4], entry[5]);
            Time difference = new Time(entry[6], entry[7], entry[8]);
            System.out.println(from + " " + to + " " + difference + "\n" + from.differenceTo(to));
            return dynamicTest(String.format("From %s to %s should be %s", from, to, difference),
                    () -> assertTrue(difference.isEqualTo(from.differenceTo(to)))
            );
        });
    }
}