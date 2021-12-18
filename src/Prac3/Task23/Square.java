package Prac3.Task23;

public class Square extends Rectangle {
    public Square() {

    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide(){
        return this.width;
    }

    public void setSide(double side){
        width = side;
        length = side;
    }

    @Override
    public void setWidth(double side) {
        width = side;
        length = side;
    }

    @Override
    public void setLength(double side) {
        width = side;
        length = side;
    }

    @Override
    public String toString() {
        return "Square:\ncolor: " + color + ", is filled: " + filled + ", side: " + width;
    }

}
