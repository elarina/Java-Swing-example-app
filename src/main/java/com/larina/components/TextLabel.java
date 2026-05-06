package main.java.com.larina.components;

import main.java.com.larina.model.TextContainer;

import javax.swing.*;
import java.awt.*;

public class TextLabel extends JLabel {
    private final TextContainer textContainer;

    public TextLabel(TextContainer textContainer){
        this.textContainer = textContainer;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setText(textContainer.getText());
    }
}
