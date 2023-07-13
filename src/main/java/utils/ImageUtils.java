package utils;

import javax.swing.*;

public class ImageUtils {

    private static ImageIcon mainIcon;

    static {
        mainIcon = new ImageIcon(getURL("cloud.png"));

    }

    private static String getURL(String fileName) {
        try {
            return ImageUtils.class.getClassLoader().getResource(fileName).getPath();
        } catch (Exception e) {
            return null;
        }
    }

    public static ImageIcon getMainIcon() {
        return mainIcon;
    }
}
