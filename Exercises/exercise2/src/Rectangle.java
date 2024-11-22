public class Rectangle extends Shape{
    double length;
    double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return (this.length * this.width);
    }

    @Override
    public double calculatePerimeter() {
        return (2 * (this.length + this.width));
    }
}