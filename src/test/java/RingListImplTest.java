import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RingListImplTest {

    @Test
    @DisplayName("Empty List")
    void emptyList() {
        RingListImpl ringList = new RingListImpl();
        assertEquals("[]", ringList.toString());
    }

    @Test
    @DisplayName("add(1, 2, 3, 4)")
    void add() {
        RingListImpl ringList = new RingListImpl();
        ringList.add(1);
        ringList.add(2);
        ringList.add(3);
        ringList.add(4);
        assertEquals("[1, 2, 3, 4]", ringList.toString());
    }

    @Test
    @DisplayName("addAll(1, 2, 3, 4)")
    void addAll() {
        RingListImpl ringList = createDemoRingList();
        assertEquals("[1, 2, 3, 4]", ringList.toString());
    }

    @Test
    @DisplayName("add(1, 2, 3, 4) + rotate()")
    void addRotate() {
        RingListImpl ringList = createDemoRingList();
        ringList.rotate();
        assertEquals("[2, 3, 4, 1]", ringList.toString());
    }

    @Test
    @DisplayName("add(1, 2, 3, 4) + rotate() + rotate()")
    void addRotateTwice() {
        RingListImpl ringList = createDemoRingList();
        ringList.rotate();
        ringList.rotate();
        assertEquals("[3, 4, 1, 2]", ringList.toString());
    }

    @Test
    @DisplayName("add(1, 2, 3, 4) + contains(0)")
    void containsFalse() {
        RingListImpl ringList = createDemoRingList();
        assertFalse(ringList.contains(0));
    }

    @Test
    @DisplayName("add(1, 2, 3, 4) + contains(3)")
    void containsTrue() {
        RingListImpl ringList = createDemoRingList();
        assertTrue(ringList.contains(3));
    }

    @Test
    @DisplayName("add(1, 2, 3, 4) + removeCurrent()")
    void addAndRemoveCurrent() {
        RingListImpl ringList = createDemoRingList();
        ringList.removeCurrent();
        assertEquals("[2, 3, 4]", ringList.toString());
    }

    @Test
    @DisplayName("add(1, 2, 3, 4) + rotate() + rotate() + removeCurrent() + removeCurrent()")
    void addRotateTwiceAndRemoveTwice() {
        RingListImpl ringList = createDemoRingList();
        ringList.rotate();
        ringList.rotate();
        ringList.removeCurrent();
        ringList.removeCurrent();
        assertEquals("[1, 2]", ringList.toString());
    }

    @Test
    @DisplayName("RingList to String: [n1, n2, ..., nx]")
    void testToString() {
        RingListImpl ringList = createDemoRingList();
        assertEquals("[1, 2, 3, 4]", ringList.toString());
    }

    private RingListImpl createDemoRingList() {
        RingListImpl ringList = new RingListImpl();
        ringList.addAll(1, 2, 3, 4);
        return ringList;
    }
}