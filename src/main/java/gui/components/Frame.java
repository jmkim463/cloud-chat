package gui.components;

import utils.ImageUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Frame extends JFrame {

    static BufferedImage icon;

    int width = 1000;
    int height = 700;

    static {
        UIManager.put("Button.font", new Font());
        UIManager.put("TextArea.font", new Font());

        UIManager.put("Panel.background", Color.white);
    }

    public Frame() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(width, height);
        setFont(new Font());
        setIconImage(ImageUtils.getMainImageIcon().getImage());
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height);
        setLocationRelativeTo(null);
    }

}
