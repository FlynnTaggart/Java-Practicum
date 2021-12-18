package Lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextWindow extends JFrame {
    Font fnt1 = new Font("Times new roman",Font.PLAIN,20);
    Font fnt2 = new Font("MS Sans Serif",Font.PLAIN,20);
    Font fnt3 = new Font("Courier New",Font.PLAIN,20);

    JRadioButtonMenuItem blue    = new JRadioButtonMenuItem("Blue");
    JRadioButtonMenuItem red     = new JRadioButtonMenuItem("Red");
    JRadioButtonMenuItem black   = new JRadioButtonMenuItem("Black");

    JRadioButtonMenuItem times   = new JRadioButtonMenuItem("Times new roman");
    JRadioButtonMenuItem sans    = new JRadioButtonMenuItem("MS Sans Serif");
    JRadioButtonMenuItem courier = new JRadioButtonMenuItem("Courier New");

    JTextArea textArea = new JTextArea();

    private JMenu CreateColorMenu(){
        JMenu color = new JMenu("Color");
        blue.setForeground(Color.BLUE);
        red.setForeground(Color.RED);
        black.setForeground(Color.BLACK);
        ButtonGroup bg = new ButtonGroup();
        bg.add(blue);
        bg.add(red);
        bg.add(black);
        color.add(blue);
        color.add(red);
        color.add(black);
        return color;
    }

    private JMenu CreateFontMenu(){
        JMenu font = new JMenu("Font");
        times.setFont(fnt1);
        sans.setFont(fnt2);
        courier.setFont(fnt3);
        ButtonGroup bg = new ButtonGroup();
        bg.add(times);
        bg.add(sans);
        bg.add(courier);
        font.add(times);
        font.add(sans);
        font.add(courier);
        return font;
    }

    ActionListener ButtonGroupActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
            AbstractButton aButton = (AbstractButton) actionEvent.getSource();
            switch (aButton.getText()){
                case "Blue":
                    textArea.setForeground(Color.BLUE);
                    break;
                case "Red":
                    textArea.setForeground(Color.RED);
                    break;
                case "Black":
                    textArea.setForeground(Color.BLACK);
                    break;
                case "Times new roman":
                    textArea.setFont(fnt1);
                    break;
                case "MS Sans Serif":
                    textArea.setFont(fnt2);
                    break;
                case "Courier New":
                    textArea.setFont(fnt3);
                    break;
            }
        }
    };

    public TextWindow() {
        setSize(800, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        textArea.setForeground(Color.BLACK);
        textArea.setFont(fnt1);
        add(textArea);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(CreateColorMenu());
        menuBar.add(CreateFontMenu());
        blue.addActionListener(ButtonGroupActionListener);
        red.addActionListener(ButtonGroupActionListener);
        black.addActionListener(ButtonGroupActionListener);
        times.addActionListener(ButtonGroupActionListener);
        sans.addActionListener(ButtonGroupActionListener);
        courier.addActionListener(ButtonGroupActionListener);
        setJMenuBar(menuBar);
    }
}
