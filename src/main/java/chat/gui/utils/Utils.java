package chat.gui.utils;

import javax.swing.*;
import java.awt.*;

public class Utils {

    public static JLabel changeLabelFontSize(int size, JLabel label) {
        Font font = label.getFont();
        label.setFont(new Font(font.getFontName(), font.getStyle(), size));
        return label;
    }

    public static JComponent getEmptyComponent(int height) {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(1, height));
        return panel;
    }
}
