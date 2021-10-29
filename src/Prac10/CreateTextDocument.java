package Prac10;

public class CreateTextDocument implements ICreateDocument{
    @Override
    public IDocument CreateNew() {
        return new TextDocument("TextDocument");
    }

    @Override
    public IDocument CreateOpen() {
        return new TextDocument("TextDocument");
    }

    @Override
    public IDocument CreateNew(String name) {
        return new TextDocument(name);
    }

    @Override
    public IDocument CreateOpen(String name) {
        return new TextDocument(name);
    }
}
