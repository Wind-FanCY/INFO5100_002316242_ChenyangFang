public class Main {
    public static void main(String[] args) {
        Shape triangle = new Triangle(3, 4, 3, 4, 5);
        Shape rectangle = new Rectangle(5, 7);
        Shape circle = new Circle(3);
        Shape square = new Square(5);

        Shape[] shapes = {triangle, rectangle, circle, square};
        String[] name = {"Triangle", "Rectangle", "Circle", "Square"};

        for(int i = 0; i < shapes.length; i++) {
            System.out.println("------------------------------------------------------");
            Shape.setName(name[i]);
            System.out.println("The shape is " + Shape.getName() + ". Its area is " + String.format("%.2f", shapes[i].calculateArea()) + " and its perimeter is " + String.format("%.2f", shapes[i].calculatePerimeter()) + ".");
        }
    }
}
