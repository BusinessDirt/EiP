public class Point {

    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point other) {
        double xDiff = this.x - other.x;
        double yDiff = this.y - other.y;
        return Pythagoras.calculate(xDiff, yDiff);
    }

    public void shift(double xShift, double yShift) {
        this.x += xShift;
        this.y += yShift;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
