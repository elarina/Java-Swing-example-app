package main.java.com.larina.main;

import main.java.com.larina.frames.MainFrame;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String... args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new MainFrame();
                frame.setTitle("Example Java Swing application");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });

    }
}
