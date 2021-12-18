package Lab4;

public class Book implements Priceable {
    float price = 100.0f;
    String title = "Unknown";
    String author = "Unknown";

    public float getPrice(){
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book() {
    }

    public Book(float price, String title, String author) {
        this.price = price;
        this.title = title;
        this.author = author;
    }
}
