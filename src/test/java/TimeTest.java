import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    @DisplayName("Calculating the difference between to times should work")
    void differenceTo() {
        boolean b1 = differenceToHelper(12, 48, 49, 12, 12, 12, 1, 1, 1);
        boolean b2 = differenceToHelper(9, 28, 33, 3, 45, 42, 13, 14, 15);
        boolean b3 = differenceToHelper(14, 2, 12, 25, 12, 3, 14, 14, 15);
        boolean b4 = differenceToHelper(5, 28, 51, 23, 55, 4, 5, 23, 55);
        assertAll(
                () -> assertTrue(b1),
                () -> assertTrue(b2),
                () -> assertTrue(b3),
                () -> assertTrue(b4)
        );
    }

    private boolean differenceToHelper(int differenceHour, int differenceMinute, int differenceSecond, int fromHour, int fromMinute, int fromSecond, int toHour, int toMinute, int toSecond) {
        Time difference = new Time(differenceHour, differenceMinute, differenceSecond);
        Time from = new Time(fromHour, fromMinute, fromSecond);
        Time to = new Time(toHour, toMinute, toSecond);
        return difference.isEqualTo(from.differenceTo(to));
    }
}