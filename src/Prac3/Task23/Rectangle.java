package Prac3.Task23;

public class Rectangle extends Shape {
    protected double width;
    protected double length;

    public Rectangle(){
        width = 0;
        length = 0;
    }

    public Rectangle(double width, double lenght){
        super();
        this.width = width;
        this.length = lenght;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Rectangle:\ncolor: " + color + ", is filled: " + filled + ", width: " + width + ", length: " + length;
    }
}
