package Lab3;

public class Main {

    public static void main(String[] args) {
        FurnitureShop furnitureShop = new FurnitureShop(10, 6, 1, 5);
        furnitureShop.buyChair();
        System.out.println(furnitureShop);
        furnitureShop.buyChair();
        furnitureShop.buyDishwashers();
        furnitureShop.buyCabinet();
        System.out.println(furnitureShop);
    }
}
