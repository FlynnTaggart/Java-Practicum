package Lab3;

public class Cabinet extends Furniture {
    public void Do(){
        System.out.println("Cabinet is opening");
    }

    public Cabinet(double mass, double length, double width, double height, String material) {
        super(mass, length, width, height, material, 150);
    }

    public Cabinet() {
        this.price = 150;
    }
}
