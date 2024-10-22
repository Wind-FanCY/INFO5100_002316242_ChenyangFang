public class Circle extends Shape {
    private static final long serialVersionUID = 1L;
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return (Math.PI * Math.pow(this.radius, 2));
    }

    @Override
    public double calculatePerimeter() {
        return (2 * Math.PI * this.radius);
    }
}
