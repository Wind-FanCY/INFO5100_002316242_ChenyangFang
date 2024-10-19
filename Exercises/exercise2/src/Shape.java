abstract class Shape {
    static String name;

    public abstract double calculateArea();
    public double calculatePerimeter() {
        return -1;
    }

    public static void setName(String n){
        name = n;
    }

    public static String getName() {
        return name;
    }
}

