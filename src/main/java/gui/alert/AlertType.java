package gui.alert;

import gui.utils.ImageUtils;

import javax.swing.*;
import java.awt.*;

public enum AlertType {
    SUCCESS("SUCCESS", getImageIcon("check", new Color(168, 216, 132))),
    ERROR("ERROR", getImageIcon("cancel", new Color(243, 65, 53)));

    private String name;
    private ImageIcon icon;

    AlertType(String name, ImageIcon icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public static ImageIcon getImageIcon(String fileName, Color color) {
        return new ImageIcon(ImageUtils.changePNGImageColor("icon/" + fileName + "_circle.png", color)
                .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
    }
}
