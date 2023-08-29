package chat.gui.components;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicMenuItemUI;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PopupMenu extends JPopupMenu {

    List<JMenuItem> itemList = new ArrayList<>();

    public PopupMenu() {
        init();
    }

    private void init() {
        setBackground(Color.white);
        setBorder(new LineBorder(Color.black));
    }

    public void addItem(String text, ActionListener actionListener) {
        JMenuItem item = new JMenuItem(text);
        item.setFont(new Font(12));
        item.setBorderPainted(false);
        item.addActionListener(actionListener);
        item.setUI(new BasicMenuItemUI() {
            @Override
            protected void paintMenuItem(Graphics g, JComponent c, Icon checkIcon, Icon arrowIcon, Color background, Color foreground, int defaultTextIconGap) {
                super.paintMenuItem(g, c, checkIcon, arrowIcon, Color.white, foreground, defaultTextIconGap);
            }
        });

        itemList.add(item);
        add(item);
    }

}
