package homework.shape;

public class Triangle implements Shape {

    double side1;
    double side2;
    double side3;

    Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double area() {
        return (side1 + side2 + side3) * 0.5;
    }

    @Override
    public double perimeter() {
        return side1 + side2 + side3;
    }
}
