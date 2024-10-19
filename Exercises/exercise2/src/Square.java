public class Square extends Shape{
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
