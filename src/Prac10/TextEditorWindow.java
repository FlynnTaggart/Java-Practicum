package Prac10;

import javax.swing.*;
import java.awt.*;

public class TextEditorWindow extends EditorWindow{
    JTextArea textArea = new JTextArea();
    public TextEditorWindow(ICreateDocument factory) {
        super(factory);
        setLayout(new BorderLayout());
        add(textArea);
    }

    @Override
    protected void fileMenuSave() {
        contents = textArea.getText();
    }

    @Override
    protected void fileMenuOpen() {
        textArea.setText((String) contents);
    }

    @Override
    protected void fileMenuNew() {
        textArea.setText((String) contents);
    }
}
