public class Triangle {

    private Point a, b, c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean isEquilateral() {
        double a = this.a.distanceTo(this.b);
        double b = this.b.distanceTo(this.c);
        double c = this.c.distanceTo(this.a);

        return a == b && b == c;
    }

    public boolean isIsosceles() {
        double a = this.a.distanceTo(this.b);
        double b = this.b.distanceTo(this.c);
        double c = this.c.distanceTo(this.a);

        return a == b || a == c || b == c;
    }

    public boolean isAcute() {
        double a = this.a.distanceTo(this.b);
        double b = this.b.distanceTo(this.c);
        double c = this.c.distanceTo(this.a);

        return Pythagoras.calculate(a, b) > c &&
                Pythagoras.calculate(a, c) > b &&
                Pythagoras.calculate(b, c) > a;
    }

    public boolean isRight() {
        double a = this.a.distanceTo(this.b);
        double b = this.b.distanceTo(this.c);
        double c = this.c.distanceTo(this.a);

        return Pythagoras.calculate(a, b) == c ||
                Pythagoras.calculate(a, c) == b ||
                Pythagoras.calculate(b, c) == a;
    }

    public boolean isObtuse() {
        double a = this.a.distanceTo(this.b);
        double b = this.b.distanceTo(this.c);
        double c = this.c.distanceTo(this.a);

        return Pythagoras.calculate(a, b) < c ||
                Pythagoras.calculate(a, c) < b ||
                Pythagoras.calculate(b, c) < a;
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
    }
}
