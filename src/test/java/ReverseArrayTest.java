import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseArrayTest {

    @Test
    void reverse() {
        assertArrayEquals(null, ReverseArray.reverse(null));
        assertArrayEquals(new int[] {6, 5, 4, 3, 2, 1}, ReverseArray.reverse(new int[] {1, 2, 3, 4, 5, 6}));
        assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6}, ReverseArray.reverse(new int[] {6, 5, 4, 3, 2, 1}));
        assertArrayEquals(new int[] {0, 9, 1, 3, 5, 5}, ReverseArray.reverse(new int[] {5, 5, 3, 1, 9, 0}));
    }
}