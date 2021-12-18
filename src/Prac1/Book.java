package Prac1;

public class Book {
    private int pageCount;
    private String title;
    private String author;
    private static float pageThickness = 0.01f;

    public Book() {
        title = "Title";
        author = "Unknown";
        pageCount = 100;
    }

    public Book(String title) {
        this.title = title;
        author = "Unknown";
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        pageCount = 100;
    }

    public Book(int pageCount, String title, String author) {
        this.pageCount = pageCount;
        this.title = title;
        this.author = author;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return  "title: '" + title + '\'' +
                ", author: '" + author + '\'' +
                "pageCount: " + pageCount;
    }

    public float getBookThickness(){
        return pageThickness * pageCount;
    }
}
