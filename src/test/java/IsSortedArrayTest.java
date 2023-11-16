import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsSortedArrayTest {

    @Test
    void isSorted() {
        assertTrue(IsSortedArray.isSorted(new int[]{1, 2, 3, 4}));
        assertFalse(IsSortedArray.isSorted(new int[]{5, 2, 3, 4}));
        assertFalse(IsSortedArray.isSorted(new int[] {1, 2, 5, 4}));
    }
}