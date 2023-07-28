package gui.utils;

import java.awt.*;

public class Colors {

    private final static Color BORDER_LINE_COLOR = new Color(227, 227, 227);
    private final static Color BUTTON_BACKGROUND_COLOR = new Color(25, 167, 206);
    private final static Color PRESS_BACKGROUND_COLOR = new Color(20, 108, 148);

    public static Color getButtonBackgroundColor() {
        return BUTTON_BACKGROUND_COLOR;
    }

    public static Color getBorderLineColor() {
        return BORDER_LINE_COLOR;
    }

    public static Color getPressBackgroundColor() {
        return PRESS_BACKGROUND_COLOR;
    }
}
