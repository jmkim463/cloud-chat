package utils;

import javax.swing.*;
import java.awt.*;

public class Utils {

    public static JPanel coverComponentsFlowlayout(Component...components) {
        JPanel panel = new JPanel(new FlowLayout());

        for(Component component : components) {
            panel.add(component);
        }

        return panel;
    }

    public static JLabel changeLabelFontSize(int size, JLabel label) {
        Font font = label.getFont();
        label.setFont(new Font(font.getFontName(), font.getStyle(), size));
        return label;
    }
}
