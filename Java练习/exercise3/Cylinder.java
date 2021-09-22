package exercise3;

public class Cylinder extends Circle {
    double length;

    public Cylinder() {
        length =1.0;
    }//这里就就有一个super（）；

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    public double findVolume(){
        //return  Math.PI*getRadius()*getRadius()*length;
        return findArea()*length;
    }
}
