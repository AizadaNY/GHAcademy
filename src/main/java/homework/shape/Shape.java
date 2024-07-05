package homework.shape;

public interface Shape {


    default double area(){

        return 0;
    }

    default double perimeter(){

        return 0;
    }
}
