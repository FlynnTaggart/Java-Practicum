package Lab3;

public class FurnitureShop {
    int cabinets;
    int tables;
    int chairs;
    int dishwashes;

    int balance = 1000;

    Cabinet cabinet = new Cabinet();
    Chair chair = new Chair();
    Table table = new Table();
    Dishwasher dishwasher = new Dishwasher();

    public FurnitureShop(int cabinets, int tables, int chairs, int dishwashes) {
        this.cabinets = cabinets;
        this.tables = tables;
        this.chairs = chairs;
        this.dishwashes = dishwashes;
    }

    public int getCabinets() {
        return cabinets;
    }

    public int getTables() {
        return tables;
    }

    public int getChairs() {
        return chairs;
    }

    public int getDishwashes() {
        return dishwashes;
    }

    void buyCabinet(){
        if(cabinets != 0) {
            balance += cabinet.getPrice();
            cabinets--;
        }
        else
            System.out.println("No cabinets in the shop");
    }

    void buyChair(){
        if(chairs != 0) {
            balance += chair.getPrice();
            chairs--;
        }
        else
            System.out.println("No chairs in the shop");
    }

    void buyTable(){
        if(tables != 0) {
            balance += table.getPrice();
            tables--;
        }
        else
            System.out.println("No tables in the shop");
    }

    void buyDishwashers(){
        if(dishwashes != 0) {
            balance += dishwasher.getPrice();
            dishwashes--;
        }
        else
            System.out.println("No dishwashes in the shop");
    }

    @Override
    public String toString() {
        return "cabinets: " + cabinets +
                ", tables: " + tables +
                ", chairs: " + chairs +
                ", dishwashes: " + dishwashes;
    }
}
