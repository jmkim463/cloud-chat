package gui.layout.login.view;

import gui.components.LabelBuilder;
import gui.components.Panel;
import utils.ImageUtils;

import javax.swing.*;
import java.awt.*;

public class LoginSideBar extends Panel {

    public LoginSideBar() {
        init();
    }

    private void init() {
        setBackground(new Color(71, 126, 251));
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 150));
        setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        JLabel image = new JLabel(
                ImageUtils.setImageIconSize(400, 275,
                        new ImageIcon(ImageUtils.getURL("login-image.png"))));

        Panel grid = new Panel(new GridLayout(0, 1, 0, 0));
        grid.setBackground(getBackground());
        grid.setBorder(BorderFactory.createEmptyBorder(50, 0, 0 ,0));

        grid.add(new LabelBuilder("test label maker easy comment")
                .setFont(1, 15).setColor(Color.white).setHorizontalCenter().getLabel());
        grid.add(new LabelBuilder("ejejgrp Tmqmsmrp whgrp")
                .setFont(1, 15).setColor(Color.white).setHorizontalCenter().getLabel());

        Panel panel = new Panel(new BorderLayout());
        panel.setBackground(getBackground());
        panel.add(image);
        panel.add(grid, BorderLayout.SOUTH);

        add(panel);
    }

}
