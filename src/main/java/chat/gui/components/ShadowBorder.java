package chat.gui.components;

import chat.gui.utils.Colors;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class ShadowBorder extends MatteBorder {

    private final static Color color = new Color(100, 100, 100, 10);

    int size;

    public ShadowBorder(int size) {
        super(0, 0, size, 0, (Color) null);

        this.size = size;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(Colors.getBorderLineColor());
        g.fillRect(0, height - size, width, 1);

        g.setColor(color);
        g.fillRect(0, height - size, width, size);
    }
}
