package main.java.com.larina.components;

import main.java.com.larina.model.TextContainer;

import java.awt.*;

public class AutoEditTextScrollPane extends TextScrollPane {
    private final TextContainer textContainer;

    public AutoEditTextScrollPane(TextContainer textContainer){
        this.textContainer = textContainer;
        getTextArea().setDisabledTextColor(SystemColor.BLACK);
        getTextArea().setEnabled(false);
        getTextArea().setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.getTextArea().setText(textContainer.getText());
    }
}
