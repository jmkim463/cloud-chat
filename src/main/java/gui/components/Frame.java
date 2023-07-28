package gui.components;

import gui.utils.Colors;
import gui.utils.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Frame extends JFrame {

    static BufferedImage icon;

    int width = 1000;
    int height = 700;

    static {
        UIManager.put("Button.font", new Font());
        UIManager.put("TextArea.font", new Font());
        UIManager.put("TextField.font", new Font());
        UIManager.put("TextField.border", BorderFactory.createMatteBorder(0, 0, 1, 0, Colors.getBorderLineColor()));
        UIManager.put("PasswordField.border", BorderFactory.createMatteBorder(0, 0, 1, 0, Colors.getBorderLineColor()));

        UIManager.put("Panel.background", Color.white);
        UIManager.put("ComboBox.background", Color.white);
    }

    public Frame() {
        setSize(width, height);
        setFont(new Font());
        setIconImage(ImageUtils.getMainImageIcon().getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height);
        setLocationRelativeTo(null);
    }

}
