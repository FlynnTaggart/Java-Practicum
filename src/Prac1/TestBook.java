package Prac1;

public class TestBook {

    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book(2000, "War and Peace", "Lev Tolstoi");
        Book book3 = new Book("Dune", "Frank Herbert");
        Book book4 = new Book("Harry Potter");
        book1.setTitle("Hiperion");
        System.out.println(book2.getAuthor());
        book3.setPageCount(800);
        System.out.println(book3);
        System.out.println(String.format("Book 2 thickness: %f", book2.getBookThickness(), " sm"));
    }
}