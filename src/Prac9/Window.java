package Prac9;

import Prac10.ICreateDocument;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    Checker checker = new Checker();
    JTextField nameField = new JTextField(40);
    JTextField INNField = new JTextField(12);
    JButton submitButton = new JButton("Submit");
    JLabel Message = new JLabel("");
    public Window() {
        setSize(640, 480);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        Box box = Box.createVerticalBox();
        Box nameBox = Box.createHorizontalBox();
        Box INNBox = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel("Full name");
        JLabel INNLabel = new JLabel("INN");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    checker.setFullName(nameField.getText());
                    checker.enterINN(INNField.getText());
                    Message.setText("Correct!");
                    Message.setForeground(Color.GREEN);
                }
                catch (InvalidINNException err){
                    Message.setText("Error: " + err.getMessage());
                    Message.setForeground(Color.RED);
                }
            }
        });
        nameBox.add(nameLabel);
        nameBox.add(nameField);
        INNBox.add(INNLabel);
        INNBox.add(INNField);
        box.add(nameBox);
        box.add(INNBox);
        box.add(submitButton);
        box.add(Message);
        add(box);
    }
}
