import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedQueueTest {

    @Test
    @DisplayName("Create empty queue")
    void createEmptyQueue() {
        LinkedQueue emptyQueue = new LinkedQueue();
        assertTrue(emptyQueue.isEmpty());
    }

    @Test
    @DisplayName("Create queue and append element -> is not empty")
     void createQueueAndAppendElement() {
        LinkedQueue queue = new LinkedQueue();
        queue.append(1);
        assertFalse(queue.isEmpty());
    }

    @Test
    @DisplayName("Create queue and 2 append element -> is not empty")
    void createQueueAndAppendTwoElements() {
        LinkedQueue queue = new LinkedQueue();
        queue.append(1);
        queue.append(2);
        assertFalse(queue.isEmpty());
    }

    @Test
    @DisplayName("Remove from empty queue keeps it empty")
    void removeFromEmptyQueue() {
        LinkedQueue queue = new LinkedQueue();
        queue.remove();
        assertTrue(queue.isEmpty());
    }

    @Test
    @DisplayName("Removing all elements makes queue empty")
    void removeAllFromQueue() {
        LinkedQueue queue = new LinkedQueue();
        queue.append(1);
        queue.append(1);
        queue.remove();
        queue.remove();
        assertTrue(queue.isEmpty());
    }

    @Test
    @DisplayName("Not removing all elements makes queue not empty")
    void dontRemoveAllFromQueue() {
        LinkedQueue queue = new LinkedQueue();
        queue.append(1);
        queue.append(1);
        queue.remove();
        assertFalse(queue.isEmpty());
    }

    @Test
    @DisplayName("Append 42 and peek")
    void appendAndPeek() {
        LinkedQueue queue = new LinkedQueue();
        queue.append(42);
        assertEquals(42, queue.peek());
    }

    @Test
    @DisplayName("Peek on empty queue")
    void peekOnEmptyQueue() {
        LinkedQueue queue = new LinkedQueue();
        assertEquals(-1, queue.peek());
    }

    @Test
    @DisplayName("Empty queue to array")
    void emptyQueueToArray() {
        LinkedQueue emptyQueue = new LinkedQueue();
        int[] queueArray = emptyQueue.toArray();
        assertArrayEquals(new int[0], queueArray);
    }
}