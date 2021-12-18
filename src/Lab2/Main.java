package Lab2;

public class Main {

    public static void main(String[] args) {
	    Book b1 = new Book();
	    Book b2 = new Book("Lev Tolstoi", "War and Peace");
	    Book b3 = new Book("Frank Herbert", "Dune",  1965);
	    System.out.println(b3.getTitle());
	    b1.setTitle("Harry Potter");
    }
}
