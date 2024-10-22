public class Square extends Shape {
    private static final long serialVersionUID = 1L; // Version control for serialization
    double edge;

    public Square(double edge) {
        this.edge = edge;
    }

    @Override
    public double calculateArea() {
        return (Math.pow(this.edge, 2));
    }

    @Override
    public double calculatePerimeter() {
        return (4 * this.edge);
    }
}
