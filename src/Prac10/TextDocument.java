package Prac10;

public class TextDocument implements IDocument{
    String name;
    String contents;

    public TextDocument(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void writeContents(Object contents) {
        this.contents = (String) contents;
        System.out.println("Contents written!!");
    }

    @Override
    public Object getContents() {
        return contents;
    }
}
