package Lab4;

public class Computer implements Priceable {
    protected float price = 500.0f;
    protected String model = "Unknown";
    protected String cpu = "INTEL CORE I99-9999999";

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public Computer() {
    }

    public Computer(float price, String model, String cpu) {
        this.price = price;
        this.model = model;
        this.cpu = cpu;
    }
}
