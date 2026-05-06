package main.java.com.larina.components;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelButton extends JButton {
    public CancelButton(ActionListener listener) {
        setText("Cancel");
        addActionListener(listener);
    }
}
