package Prac10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class EditorWindow extends JFrame {

    ICreateDocument createDocumentFactory;
    IDocument document;

    Object contents;

    ActionListener fileMenuActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem aMenuItem = (JMenuItem) e.getSource();
            switch (aMenuItem.getText()){
                case "New":
                    document = createDocumentFactory.CreateNew();
                    contents = document.getContents();
                    fileMenuNew();
                    break;
                case "Open":
                    document = createDocumentFactory.CreateOpen();
                    contents = document.getContents();
                    fileMenuOpen();
                    break;
                case "Save":
                    fileMenuSave();
                    document.writeContents(contents);
                    break;
                case "Exit":
                    System.exit(0);
                    break;
            }
        }
    };

    protected abstract void fileMenuSave();
    protected abstract void fileMenuOpen();
    protected abstract void fileMenuNew();

    private JMenu createFileMenu(){
        JMenu fileMenu = new JMenu("File");
        JMenuItem newFile = new JMenuItem("New");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem exit = new JMenuItem("Exit");
        fileMenu.add(newFile);
        fileMenu.add(open);
        fileMenu.add(save);
        fileMenu.addSeparator();
        fileMenu.add(exit);
        newFile.addActionListener(fileMenuActionListener);
        open.addActionListener(fileMenuActionListener);
        save.addActionListener(fileMenuActionListener);
        exit.addActionListener(fileMenuActionListener);
        return fileMenu;
    }

    public EditorWindow(ICreateDocument factory) {
        createDocumentFactory = factory;
        setSize(640, 480);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createFileMenu());
        setJMenuBar(menuBar);
    }
}
