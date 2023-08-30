package chat.gui.components;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.Font;

public class ToolTip extends JToolTip {

    public ToolTip(JComponent component) {
        setComponent(component);
        setBorder(new LineBorder(Color.black));
        setBackground(Color.WHITE);
        setFont(new Font("나눔고딕", 0, 13));
        setForeground(Color.BLACK);
    }

}
