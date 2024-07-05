package homework.shape;

public class Square implements Shape{

    double side1;
    double side2;

    Square(double side1,double side2){
        this.side1=side1;
        this.side2=side2;
    }

    @Override
    public double area() {
        return side1*side2;
    }

    @Override
    public double perimeter() {
        return (side1*side2)/2;
    }
}
