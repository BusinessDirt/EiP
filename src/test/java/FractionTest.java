import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    @Test
    void multiply() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 5);
        f1.multiply(f2);
        assertEquals(1, f1.nominator);
        assertEquals(10, f1.denominator);
    }

    @Test
    void add() {
        // 1/2 + 1/5 = 7/10
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 5);
        f1.add(f2);
        assertEquals(7, f1.nominator);
        assertEquals(10, f1.denominator);
    }

    @Test
    void testToString() {
        Fraction f1 = new Fraction(8, 5);
        assertEquals("8/5", f1.toString());

        Fraction f2 = new Fraction(42);
        assertEquals("42/1", f2.toString());
    }

    @Test
    void asDouble() {
        Fraction f1 = new Fraction(8, 5);
        assertEquals(8d/5d, f1.asDouble());

        Fraction f2 = new Fraction(524, 10);
        assertEquals(524d/10d, f2.asDouble());
    }
}