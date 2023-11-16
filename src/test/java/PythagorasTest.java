import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PythagorasTest {


    @Test
    void calculate() {
        assertEquals(5.0d, Pythagoras.calculate(3.0d, 4.0d));
    }
}