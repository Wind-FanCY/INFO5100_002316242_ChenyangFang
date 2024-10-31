import java.io.Serializable;

abstract class Shape implements Serializable {
    private static final long serialVersionUID = 1L;
    static String name;

    public abstract double calculateArea();

    public double calculatePerimeter() {
        return -1;
    }

    public static void setName(String n) {
        name = n;
    }

    public static String getName() {
        return name;
    }
}
