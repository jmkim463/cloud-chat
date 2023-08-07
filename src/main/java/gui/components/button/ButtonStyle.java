package gui.components.button;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

public enum ButtonStyle {

    Primary(
        new Color(0,   121, 255),
        new Color(29,  93,  155),
        new Color(255, 255, 255)
    ),
    Secondary(
        new Color(157, 178, 191),
        new Color(82,  109, 130),
        new Color(255, 255, 255)
    ),
    Success(
        new Color(78,  159, 61),
        new Color(30,  81,  40),
        new Color(255, 255, 255)
    ),
    Danger(
        new Color(254, 0,   0),
        new Color(179, 19,  18),
        new Color(255, 255, 255)
    ),
    Warning(
        new Color(249, 132, 4),
        new Color(252, 84,  4),
        new Color(0,   0,   0)
    ),
    Info(
        new Color(135, 203, 185),
        new Color(86,  157, 170),
        new Color(255, 255, 255)
    ),
    Light(
        new Color(255, 251, 245),
        new Color(247, 239, 229),
        new Color(0,   0,   0)
    ),
    Dark(
        new Color(15,  15,  15),
        new Color(5,   5,   5),
        new Color(255, 255, 255)
    );

    private Color background;
    private Color pressBackground;
    private Color foreground;

    private ButtonStyle(Color background, Color pressBackground, Color foreground) {
        this.background = background;
        this.pressBackground = pressBackground;
        this.foreground = foreground;
    }

    public Color getBackground() {
        return background;
    }

    public Color getForeground() {
        return foreground;
    }

    public Color getPressBackground() {
        return pressBackground;
    }
}
