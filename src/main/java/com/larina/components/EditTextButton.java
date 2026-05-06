package main.java.com.larina.components;

import main.java.com.larina.frames.EditTextFrame;
import main.java.com.larina.model.TextContainer;
import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditTextButton extends JButton {

    private final int textFrameWidth;
    private final int textFrameHeight;
    private final TextContainer textContainer;
    private final Runnable repainter;

    public EditTextButton(int textFrameWidth, int textFrameHeight, TextContainer textContainer, Runnable repainter){
        setText("Edit text button (second frame example)");
        this.textFrameWidth = textFrameWidth;
        this.textFrameHeight = textFrameHeight;
        this.textContainer = textContainer;
        this.repainter = repainter;
    }

    @Override
    protected void init(String text, Icon icon) {
        super.init(text, icon);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame textFrame = new EditTextFrame(textFrameWidth, textFrameHeight, textContainer, repainter);
                textFrame.setVisible(true);
            }
        });
    }
}
