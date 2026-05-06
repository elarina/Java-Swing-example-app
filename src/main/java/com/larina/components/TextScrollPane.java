package main.java.com.larina.components;

import javax.swing.*;
import java.awt.*;

public class TextScrollPane extends JScrollPane {
    private final JTextArea area;

    public TextScrollPane(){
        this.area = new JTextArea();
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        setViewportView(area);
    }

    public JTextArea getTextArea(){
        return this.area;
    }
}
