public interface RingList {
    /**
     * Insert a value before the current head of the list.
     * Take care to correctly keep the circularity of the list.
     */
    void add(int value);

    /**
     * @return the value of the head of the list.
     */
    int getCurrentValue();

    /**
     * Rotate the list by one to the right (like in the example)
     */
    void rotate();

    /**
     * Remove the current head of the list.
     * Take care to correctly keep the circularity of the list.
     */
    void removeCurrent();

    /**
     * Check if the list contains the provided value.
     * Make sure to always terminate.
     */
    boolean contains(int value);
}
