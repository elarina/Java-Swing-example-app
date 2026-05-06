package main.java.com.larina.frames;

import main.java.com.larina.components.CancelButton;
import main.java.com.larina.components.OkButton;
import main.java.com.larina.components.TextScrollPane;
import main.java.com.larina.model.TextContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditTextFrame extends JFrame {

    private final TextContainer textContainer;
    private final JFrame currentFrame = this;
    private final Runnable repainter;
    public EditTextFrame(int width, int height, TextContainer textContainer, Runnable repainter) {
        setTitle("Edit text");
        setSize(width, height);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setLocation(screenSize.width / 2 - width / 2, screenSize.height / 2 - height / 2);
        this.textContainer = textContainer;
        this.repainter = repainter;
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        addContent(panel);
        getContentPane().add(panel);
    }

    private void addContent(JPanel panel) {
        JTextArea area = addTextArea(panel);
        addButtons(panel, area);
    }

    private void addButtons(JPanel panel, JTextArea area) {
        addIndent(panel);
        addOkButton(panel, area);
        addCancelButton(panel);
    }

    private void addCancelButton(JPanel panel) {
        JButton cancelButton = new CancelButton(e -> dispose());
        GridBagConstraints gbcCancel = new GridBagConstraints();
        gbcCancel.insets = new Insets(10, 5, 20, 10);
        gbcCancel.gridx = 18;
        gbcCancel.gridy = 1;
        gbcCancel.fill = GridBagConstraints.HORIZONTAL;
        gbcCancel.gridwidth = 1;
        gbcCancel.weightx = 0.25;
        gbcCancel.anchor = GridBagConstraints.EAST;
        panel.add(cancelButton, gbcCancel);
    }

    private void addOkButton(JPanel panel, JTextArea area) {
        JButton okButton = new OkButton(e -> {
            String enteredText = area.getText();
            textContainer.setText(enteredText);
            repainter.run();
            dispose();
        });
        GridBagConstraints gbcOk = new GridBagConstraints();
        gbcOk.insets = new Insets(10, 10, 20, 5);
        gbcOk.gridx = 16;
        gbcOk.gridy = 1;
        gbcOk.fill = GridBagConstraints.HORIZONTAL;
        gbcOk.gridwidth = 1;
        gbcOk.weightx = 0.25;
        gbcOk.anchor = GridBagConstraints.EAST;
        panel.add(okButton, gbcOk);
    }

    private static void addIndent(JPanel panel) {
        GridBagConstraints gbcEmpty = new GridBagConstraints();
        gbcEmpty.gridx = 0;
        gbcEmpty.gridy = 1;
        gbcEmpty.gridwidth = 15;
        gbcEmpty.weightx = 1.0;
        gbcEmpty.fill = GridBagConstraints.HORIZONTAL;
        gbcEmpty.anchor = GridBagConstraints.EAST;
        panel.add(Box.createHorizontalGlue(), gbcEmpty);
    }

    private JTextArea addTextArea(JPanel panel) {
        TextScrollPane textScrollPane = new TextScrollPane();
        textScrollPane.getTextArea().setText(textContainer.getText());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 20;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        panel.add(textScrollPane, gbc);
        return textScrollPane.getTextArea();
    }

}
