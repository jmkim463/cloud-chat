package chat.gui.components;

import chat.gui.utils.Colors;
import chat.gui.utils.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Frame extends JFrame {

    static BufferedImage icon;

    int width = 1000;
    int height = 700;

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
