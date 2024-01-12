import java.util.ArrayList;

public class Multiply implements GenericFunction<Integer, Integer> {

    private final int x;

    public Multiply(int x) {
        this.x = x;
    }

    @Override
    public Integer calculate(Integer y) {
        return x * y;
    }
}
