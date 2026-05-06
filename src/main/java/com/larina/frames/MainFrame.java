package main.java.com.larina.frames;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width / 4;
        int v = (int) (width * 0.75);
        setSize(width, v);
        setLocation(screenSize.width/2 - width/2, screenSize.height/2 - v/2);
    }
}
