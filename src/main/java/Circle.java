public class Circle {
    private double r;
    private String lineColor, fillColor;

    public Circle(double r, String lineColor, String fillColor) {
        this.r = r;
        this.lineColor = lineColor;
        this.fillColor = fillColor;
    }

    public double circumference() {
        return 2 * r * Math.PI;
    }

    public double getRadius() {
        return r;
    }

    public String getLineColor() {
        return lineColor;
    }

    public String getFillColor() {
        return fillColor;
    }

    public void setRadius(double r) {
        this.r = r;
    }

    public void setLineColor(String lineColor) {
        this.lineColor = lineColor;
    }

    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }
}
