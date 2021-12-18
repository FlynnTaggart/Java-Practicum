package Lab3;

public class Chair extends Furniture {
    public void Do(){
        System.out.println("Chair is standing");
    }

    public Chair(double mass, double length, double width, double height, String material) {
        super(mass, length, width, height, material, 20);
    }

    public Chair() {
        this.price = 20;
    }
}
