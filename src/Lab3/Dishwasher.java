package Lab3;

public class Dishwasher extends Furniture {
    public void Do(){
        System.out.println("Dishwasher is washing dishes");
    }

    public Dishwasher(double mass, double length, double width, double height, String material) {
        super(mass, length, width, height, material, 200);
    }

    public Dishwasher() {
        this.price = 200;
    }
}
