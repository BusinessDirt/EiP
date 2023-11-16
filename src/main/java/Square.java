public class Square {
    private double length;
    private String lineColor, fillColor;

    public Square(double length, String lineColor, String fillColor) {
        this.length = length;
        this.lineColor = lineColor;
        this.fillColor = fillColor;
    }

    public double area() {
        return length * length;
    }

    public double getLength() {
        return length;
    }

    public String getLineColor() {
        return lineColor;
    }

    public String getFillColor() {
        return fillColor;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setLineColor(String lineColor) {
        this.lineColor = lineColor;
    }

    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }
}
