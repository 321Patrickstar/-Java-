package exercise3;

public class Circle {
    double radius;

    public Circle() {
        radius =1.0;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double findArea(){
        return Math.PI*radius*radius;
    }
}
