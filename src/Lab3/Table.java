package Lab3;

public class Table extends Furniture {
    public void Do(){
        System.out.println("Table is standing");
    }

    public Table(double mass, double length, double width, double height, String material) {
        super(mass, length, width, height, material, 50);
    }

    public Table() {
        this.price = 50;
    }
}
