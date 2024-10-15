public class Triangle extends Shape{
    double height;
    double bottom;
    double line1;
    double line2;
    double line3;

    public Triangle(double height, double bottom, double line1, double line2, double line3) {
        this.height = height;
        this.bottom = bottom;
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
    }

    @Override
    public double calculateArea() {
        return (this.height * this.bottom / 2);
    }

    @Override
    public double calculatePerimeter() {
        return (this.line1 + this.line2 + this.line3);
    }
}
