package chat.gui.layout.friend.view;

import chat.gui.components.ImageBuilder;
import chat.gui.components.Panel;
import chat.gui.layout.popup.pending.PendingApp;
import chat.gui.utils.Colors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Header extends Panel {

    public Header() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Colors.getBorderLineColor()));

        JLabel label = new JLabel(new ImageBuilder("friend_add", ImageBuilder.ICON).setSize(35, 35).getImageIcon());
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PendingApp app = new PendingApp();
                app.open();
            }
        });

        add(label, BorderLayout.EAST);
    }

}
