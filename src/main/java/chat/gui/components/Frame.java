package chat.gui.components;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class Frame extends JFrame {

    static BufferedImage icon;

    int width = 1000;
    int height = 700;

    public Frame() {
        setSize(width, height);
        setFont(new Font());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setIconImage(new ImageBuilder("logo", ImageBuilder.RESOURCES).getImageIcon().getImage());
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height);
        setLocationRelativeTo(null);
    }

}
