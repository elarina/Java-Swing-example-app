package main.java.com.larina.frames;

import main.java.com.larina.components.AutoEditTextScrollPane;
import main.java.com.larina.components.EditTextButton;
import main.java.com.larina.model.TextContainer;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private static final int FONTSIZE = 14;
    private static final int WIDTH_DEVIDER = 4;
    private static final double WIDTH_TO_HEIGHT_RATIO = 0.75;
    private static final String INIT_TEXT = "";

    public MainFrame() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width / WIDTH_DEVIDER;
        int v = (int) (width * WIDTH_TO_HEIGHT_RATIO);
        setSize(width, v);
        setLocation(screenSize.width/2 - width/2, screenSize.height/2 - v/2);
    }

    @Override
    protected void frameInit() {
        super.frameInit();
        JPanel mainPanel = new JPanel(new GridBagLayout());
        this.add(mainPanel);
        addContent(mainPanel);
    }

    private void addContent(JPanel mainPanel) {
        TextContainer textContainer = new TextContainer(INIT_TEXT);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width / (WIDTH_DEVIDER + 1);
        JTextArea mainTextArea = addTextPanel(mainPanel, textContainer);
        addEditTextButton(mainPanel, width, textContainer);
        addIndent(mainPanel);
        JCheckBox boldCheckBox = addCheckBox("Bold", 2, mainPanel);
        JCheckBox italicCheckBox = addCheckBox("Italic", 3, mainPanel);

        boldCheckBox.addActionListener(e -> {
            int mode = boldCheckBox.isSelected() ? Font.BOLD : 0;
            if(italicCheckBox.isSelected()){
                mode += Font.ITALIC;
            }

            mainTextArea.setFont(new Font("Sefif", mode, FONTSIZE));
        });

        italicCheckBox.addActionListener(e -> {
            int mode = italicCheckBox.isSelected() ? Font.ITALIC : 0;
            if(boldCheckBox.isSelected()){
                mode += Font.BOLD;
            }
            mainTextArea.setFont(new Font("Sefif", mode, FONTSIZE));
        });
//        addCheckBox("Centered", 4, mainPanel);

    }

    private static JTextArea addTextPanel(JPanel mainPanel, TextContainer textContainer) {
        AutoEditTextScrollPane scrollPane = new AutoEditTextScrollPane(textContainer);
        GridBagConstraints gbcText = new GridBagConstraints();
        gbcText.insets = new Insets(10, 10, 10, 10);
        gbcText.gridx = 0;
        gbcText.gridy = 1;
        gbcText.gridwidth = 5;
        gbcText.weightx = 1.0;
        gbcText.fill = GridBagConstraints.BOTH;
        gbcText.weighty = 1.0;
        gbcText.anchor = GridBagConstraints.CENTER;
        mainPanel.add(scrollPane, gbcText);
        return scrollPane.getTextArea();
    }

    private static JCheckBox addCheckBox(String Italic, int gridx, JPanel mainPanel) {
        JCheckBox checkBox = new JCheckBox();
        checkBox.setText(Italic);
        GridBagConstraints gbcItalicCheck = new GridBagConstraints();
        gbcItalicCheck.insets = new Insets(10, 10, 10, 10);
        gbcItalicCheck.gridx = gridx;
        gbcItalicCheck.gridy = 0;
        gbcItalicCheck.fill = GridBagConstraints.NONE;
        gbcItalicCheck.weightx = 0;
        gbcItalicCheck.anchor = GridBagConstraints.EAST;
        mainPanel.add(checkBox, gbcItalicCheck);
        return checkBox;
    }

    private static void addIndent(JPanel mainPanel) {
        GridBagConstraints gbcEmpty = new GridBagConstraints();
        gbcEmpty.anchor = GridBagConstraints.WEST;
        gbcEmpty.gridx = 1;
        gbcEmpty.gridy = 0;
        gbcEmpty.weightx = 1.0;
        gbcEmpty.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(Box.createHorizontalGlue(), gbcEmpty);
    }

    private void addEditTextButton(JPanel mainPanel, int width, TextContainer textContainer) {
        EditTextButton editTextButton = new EditTextButton(width, (int) (width * WIDTH_TO_HEIGHT_RATIO), textContainer, this::repaint);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(editTextButton, gbc);
    }
}
