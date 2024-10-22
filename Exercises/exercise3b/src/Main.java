import java.io.*;

public class Main {
    public static void main(String[] args) {
        Shape triangle = new Triangle(3, 4, 3, 4, 5);
        Shape rectangle = new Rectangle(5, 7);
        Shape circle = new Circle(3);
        Shape square = new Square(5);

        Shape[] outShapes = {triangle, rectangle, circle, square};
        String[] outNames = {"Triangle", "Rectangle", "Circle", "Square"};

        // Serialization
        try {
            FileOutputStream fileOut1 = new FileOutputStream("shapes.ser");
            FileOutputStream fileOut2 = new FileOutputStream("names.ser");
            ObjectOutputStream out1 = new ObjectOutputStream(fileOut1);
            ObjectOutputStream out2 = new ObjectOutputStream(fileOut2);
            out1.writeObject(outShapes);
            out2.writeObject(outNames);
            out1.close();
            out2.close();
            fileOut1.close();
            fileOut2.close();
            System.out.println("Shapes serialized successfully.");
        } catch (IOException i) {
            i.printStackTrace();
        }

        // Deserialization
        Shape[] inShapes;
        String[] inNames;
        try {
            FileInputStream fileIn1 = new FileInputStream("shapes.ser");
            FileInputStream fileIn2 = new FileInputStream("names.ser");
            ObjectInputStream in1 = new ObjectInputStream(fileIn1);
            ObjectInputStream in2 = new ObjectInputStream(fileIn2);
            inShapes = (Shape[]) in1.readObject();
            inNames = (String[]) in2.readObject();
            in1.close();
            in2.close();
            fileIn1.close();
            fileIn2.close();
            System.out.println("Shapes deserialized successfully.");
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
            return;
        }

        System.out.println("Here are the data.");
        for (int i = 0; i < inShapes.length; i++) {
            Shape.setName(inNames[i]);
            System.out.println("---------------------------------------------------------------");
            System.out.println("The shape is " + Shape.getName() + ". Its area is " +
                    String.format("%.2f", inShapes[i].calculateArea()) +
                    " and its perimeter is " + String.format("%.2f", inShapes[i].calculatePerimeter()) + ".");
        }
    }
}
