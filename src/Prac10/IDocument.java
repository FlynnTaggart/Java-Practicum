package Prac10;

public interface IDocument {
    String getName();
    void setName(String name);
    void writeContents(Object contents);
    Object getContents();
}
