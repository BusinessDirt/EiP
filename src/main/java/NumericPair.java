public class NumericPair<T extends Number> extends IdenticalPair<T> {

    public NumericPair(T first, T second) {
        super(first, second);
    }

    public double sum() {
        return this.getFirst().doubleValue() + this.getSecond().doubleValue();
    }
}
