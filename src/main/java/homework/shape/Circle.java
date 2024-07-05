package homework.shape;

public class Circle implements Shape {

    double radius;
    double p = 3.14;

    Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return p * (radius * radius);
    }

    @Override
    public double perimeter() {
        return 2 * p * radius;
    }
}
