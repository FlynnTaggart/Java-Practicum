package Lab4;

public class Laptop extends Computer {
    private int screenSize = 15;

    public Laptop(float price, String model, String cpu, int screenSize) {
        super(price, model, cpu);
        this.screenSize = screenSize;
    }

    public Laptop(int screenSize) {
        model = "Acer";
        cpu = "Intel Core i5";
        this.screenSize = screenSize;
    }

    public Laptop() {
        model = "Asus";
        cpu = "Intel Core i7";
    }
}
