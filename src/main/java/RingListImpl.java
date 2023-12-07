import java.util.Arrays;

public class RingListImpl implements RingList {

    private Element current;
    private int size;

    public RingListImpl() {
        this.size = 0;
    }

    @Override
    public void add(int value) {
        this.size++;
        if (current == null) {
            this.current = new Element(value, null);
            this.current.next = this.current;
            return;
        }

        Element last = this.current.findLast(this.current);
        last.next = new Element(value, this.current);
    }

    public void addAll(int... values) {
        for (int value : values) {
            this.add(value);
        }
    }

    @Override
    public int getCurrentValue() {
        return this.current.value;
    }

    @Override
    public void rotate() {
        //this.current = this.current.findLast(this.current);
        this.current = this.current.next;
    }

    @Override
    public void removeCurrent() {
        if (this.current == null) return;
        this.size--;
        Element last = this.current.findLast(this.current);

        // only one element -> remove it
        if (last == this.current) {
            this.current = null;
            return;
        }

        // two or more elements -> remove current and link the other one to current.next
        last.next = this.current.next;
        this.current = this.current.next;
    }

    @Override
    public boolean contains(int value) {
        if (this.current != null) return this.current.contains(value, current);
        return false;
    }

    @Override
    public String toString() {
        if (this.current == null) return "[]";
        int[] array = this.current.toIntArray(0, this.current);
        return Arrays.toString(array);
    }

    private static class Element {
        int value;
        Element next;

        public Element() {}
        public Element(int value, Element next) {
            this.value = value;
            this.next = next;
        }

        public Element findLast(Element current) {
            if (this.next == current) return this;
            return this.next.findLast(current);
        }

        public boolean contains(int value, Element current) {
            if (this.value == value) return true;
            if (this.next == current) return false;
            return this.next.contains(value, current);
        }

        public int[] toIntArray(int i, Element current) {
            if (this.next == null) return new int[0];
            if (this.next == current) {
                int[] arr = new int[i + 1];
                arr[i] = this.value;
                return arr;
            }

            int[] arr = this.next.toIntArray(i + 1, current);
            arr[i] = this.value;
            return arr;
        }
    }
}
