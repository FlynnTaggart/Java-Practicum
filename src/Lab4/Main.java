package Lab4;

public class Main {

    public static void main(String[] args) {
        Book book = new Book(44f, "The War of the Worlds", "Herbert Wells");
        System.out.println(book.getPrice());
        Laptop laptop = new Laptop();
        System.out.println(laptop.getPrice());
    }
}
