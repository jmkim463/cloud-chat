package chat.gui.layout.sidebar;

import chat.gui.components.ImageBuilder;
import chat.gui.layout.sidebar.view.MenuIcon;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class SideBarView extends JPanel {

    MenuIcon personIcon;
    MenuIcon chatIcon;

    MenuIcon friendAddIcon;
    MenuIcon settingIcon;
    MenuIcon logoutIcon;

    public SideBarView() {
        personIcon = new MenuIcon("person");
        chatIcon = new MenuIcon("chat");

        friendAddIcon = new MenuIcon("friend_add");
        settingIcon = new MenuIcon("setting");
        logoutIcon = new MenuIcon("logout");

        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        setBackground(new Color(67, 142, 185));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel top = new JPanel(new GridLayout(0, 1, 0, 20));
        JPanel bottom = new JPanel(new GridLayout(0, 1, 0, 20));

        top.add(personIcon);
        top.add(chatIcon);

        bottom.add(friendAddIcon);
        bottom.add(settingIcon);
        bottom.add(logoutIcon);

        top.setOpaque(false);
        bottom.setOpaque(false);

        add(top, BorderLayout.NORTH);
        add(bottom, BorderLayout.SOUTH);
    }

    public MenuIcon getPersonIcon() {
        return personIcon;
    }

    public MenuIcon getChatIcon() {
        return chatIcon;
    }

    public MenuIcon getLogoutIcon() {
        return logoutIcon;
    }
}
