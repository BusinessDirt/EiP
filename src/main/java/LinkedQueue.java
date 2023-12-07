public class LinkedQueue implements Queue {

    private int[] list;
    private int size;

    public LinkedQueue() {
        this.list = new int[] {EMPTY_VALUE};
        this.size = 0;
    }

    private void expand() {
        int[] old = this.list;
        this.list = new int[old.length * 2];
        System.arraycopy(old, 0, this.list, 0, old.length);
    }

    @Override
    public void append(int value) {
        if (this.size >= list.length) this.expand();
        this.list[size] = value;
        this.size++;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void remove() {
        if (this.isEmpty()) return;
        this.list[0] = EMPTY_VALUE;
        for (int i = 1; i < this.size; i++) this.list[i - 1] = this.list[i];
        this.size--;
    }

    @Override
    public int peek() {
        return this.list[0];
    }

    @Override
    public int[] toArray() {
        int[] arr = new int[this.size];
        if (this.size == 0) return arr;
        System.arraycopy(this.list, 0, arr, 0, this.list.length);
        return arr;
    }
}
