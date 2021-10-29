package Prac10;

public class Main {
    public static void main(String[] args) {
        CreateTextDocument createTextDocument = new CreateTextDocument();
        TextEditorWindow editorWindow = new TextEditorWindow(createTextDocument);
        editorWindow.setVisible(true);
    }
}
