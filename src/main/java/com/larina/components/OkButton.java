package main.java.com.larina.components;

import javax.swing.*;
import java.awt.event.ActionListener;

public class OkButton extends JButton {
    public OkButton(ActionListener listener){
        setText("OK");
        this.addActionListener(listener);
    }
}
