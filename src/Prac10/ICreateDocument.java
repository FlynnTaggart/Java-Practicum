package Prac10;

public interface ICreateDocument {
    IDocument CreateNew();
    IDocument CreateOpen();
    IDocument CreateNew(String name);
    IDocument CreateOpen(String name);
}
