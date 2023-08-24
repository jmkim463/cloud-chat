package chat.gui.layout.friend.view;

import chat.gui.components.ImageBuilder;
import chat.gui.components.Panel;
import chat.gui.utils.Colors;

import javax.swing.*;
import java.awt.*;

public class Header extends Panel {

    public Header() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Colors.getBorderLineColor()));

        JLabel label = new JLabel(new ImageBuilder("friend_add", ImageBuilder.ICON).setSize(30, 30).getImageIcon());

        add(label, BorderLayout.EAST);
    }

}
