package gui.components;

import javax.swing.*;
import java.awt.*;

public class LabelFactory {

    private final static String FONT_NAME = "나눔고딕";
    private final static int FONT_STYLE = Font.PLAIN;
    private final static int FONT_SIZE = 15;

    public static Font getLabelDefaultFont() {
        return new Font(FONT_NAME, FONT_STYLE, FONT_SIZE);
    }

    private LabelFactory() {

    }

    public static JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(getLabelDefaultFont());
        return label;
    }

    public static JLabel createLabel(String text, int fontSize) {
        JLabel label = new JLabel(text);
        label.setFont(new Font(FONT_NAME, FONT_STYLE, fontSize));
        return label;
    }

    public static JLabel createLabel(String text, int fontStyle, int fontSize) {
        JLabel label = new JLabel(text);
        label.setFont(new Font(FONT_NAME, fontStyle, fontSize));
        return label;
    }

    public static JLabel createLabel(String text, int fontStyle, int fontSize,  Color color) {
        JLabel label = new JLabel(text);
        label.setFont(new Font(FONT_NAME, fontStyle, fontSize));
        label.setForeground(color);
        return label;
    }

    public static JLabel createLabel(String text, int fontSize,  Color color) {
        JLabel label = new JLabel(text);
        label.setForeground(color);
        label.setFont(new Font(FONT_NAME, FONT_STYLE, fontSize));
        return label;
    }

    public static JLabel createLabel(String text, Color color) {
        JLabel label = new JLabel(text);
        label.setForeground(color);
        label.setFont(getLabelDefaultFont());
        return label;
    }

    public static JLabel setLabelHorizontalCenter(JLabel label) {
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setHorizontalTextPosition(JLabel.CENTER);
        return label;
    }
}
