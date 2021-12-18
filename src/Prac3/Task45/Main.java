package Prac3.Task45;

public class Main {

    public static void main(String[] args) {
        MovableRectangle movRec = new MovableRectangle(0, 0, 4, 2, 10, 10);
        System.out.println(movRec);
        movRec.moveRight();
        System.out.println(movRec + "\n");
        MovableCircle movCir = new MovableCircle(5, 5, 20, 10, 3);
        System.out.println(movCir);
        movCir.moveUp();
        System.out.println(movCir);
    }
}
