package Prac2;

public class TestBall {

    public static void main(String[] args) {
        Ball b1 = new Ball();
        Ball b2 = new Ball(10.0, 10.0);
        System.out.println(b2);
        b1.setXY(-10.0, -24.0);
        b1.move(10.0, -36.0);
        System.out.println(b1);
    }
}
