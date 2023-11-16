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
    void differenceTo() {
        Time t1 = new Time(12, 12, 12);
        Time t2 = new Time(1, 1, 1);
        Time e1 = new Time(12, 48, 49);
        boolean b1 = e1.isEqualTo(t1.differenceTo(t2));
        assertTrue(b1);

        Time t3 = new Time(3, 45, 42);
        Time t4 = new Time(13, 14, 15);
        Time e2 = new Time(9, 28, 33);
        boolean b2 = e2.isEqualTo(t3.differenceTo(t4));
        assertTrue(b2);

        Time t5 = new Time(25, 12, 3);
        Time t6 = new Time(14, 14, 15);
        Time e3 = new Time(14, 2, 12);
        boolean b3 = e3.isEqualTo(t5.differenceTo(t6));
        assertTrue(b3);

        Time t7 = new Time(23, 55, 4);
        Time t8 = new Time(5, 23, 55);
        Time e4 = new Time(5, 28, 51);
        boolean b4 = e4.isEqualTo(t7.differenceTo(t8));
        assertTrue(b4);
    }
}