package Lab2;

public class Book {
    String author = "Unknown";
    String title = "Unknown";
    int yearOfPublishing = 1900;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public Book(String author, String title, int yearOfPublishing) {
        this.author = author;
        this.title = title;
        this.yearOfPublishing = yearOfPublishing;
    }

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public Book() {
    }
}
