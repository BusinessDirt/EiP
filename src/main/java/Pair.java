public class Pair<T, V> {

    private T first;
    private V second;

    public Pair(T first, V second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        if (first == null) return;
        this.first = first;
    }

    public V getSecond() {
        return second;
    }

    public void setSecond(V second) {
        if (second == null) return;
        this.second = second;
    }
}
