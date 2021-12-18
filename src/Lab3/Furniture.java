package Lab3;

public abstract class Furniture {
    protected double mass = 0;
    protected double length = 0;
    protected double width = 0;
    protected double height = 0;
    protected String material = "";
    protected int price = 0;

    public abstract void Do();

    @Override
    public String toString() {
        return "mass: " + mass +
                ", length: " + length +
                ", width: " + width +
                ", height: " + height +
                ", material: '" + material + '\''+
                ", price: $" + price;
    }

    public Furniture(double mass, double length, double width, double height, String material, int price) {
        this.mass = mass;
        this.length = length;
        this.width = width;
        this.height = height;
        this.material = material;
        this.price = price;
    }

    public Furniture() {
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
