public class Fraction {

    public int nominator, denominator;

    public Fraction(int nominator, int denominator) {
        this.nominator = nominator;
        this.denominator = denominator;
        if (denominator == 0) this.denominator = 1;
    }

    public Fraction(int n) {
        this(n, 1);
    }

    public void multiply(Fraction factor) {
        this.nominator *= factor.nominator;
        this.denominator *= factor.denominator;
    }

    public void add(Fraction summand) {
        this.nominator = this.nominator * summand.denominator + summand.nominator * this.denominator;
        this.denominator *= summand.denominator;
    }

    @Override
    public String toString() {
        return nominator + "/" + denominator;
    }

    public double asDouble() {
        return (double) nominator / denominator;
    }
}
