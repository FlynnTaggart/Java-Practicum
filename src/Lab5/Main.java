package Lab5;

import javax.swing.*;
import java.awt.*;

class Main extends JFrame {
    public Main() {
        ImageIcon icon = new ImageIcon(new ImageIcon("C:/Users/mr130/IdeaProjects/lab5/SHREK.gif").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
        JLabel label = new JLabel(icon);
        label.setSize(300, 300);
        add(label);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
    }
    public static void main(String[]args){
        new Main().setVisible(true);
    }
}