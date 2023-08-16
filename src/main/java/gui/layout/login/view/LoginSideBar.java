package gui.layout.login.view;

import gui.components.LabelBuilder;
import gui.components.Panel;
import gui.utils.ImageUtils;

import javax.swing.*;
import java.awt.*;

public class LoginSideBar extends Panel {

    public LoginSideBar() {
        init();
    }

    private void init() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 150));
        setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        JLabel image = new JLabel(
                ImageUtils.setImageIconSize(400, 275,
                        new ImageIcon(ImageUtils.getURL("login-image.png"))));

        Panel grid = new Panel(new GridLayout(0, 1, 0, 0));
        grid.setOpaque(false);
        grid.setBorder(BorderFactory.createEmptyBorder(50, 0, 0 ,0));

        grid.add(new LabelBuilder("Lorem ipsum dolor sit amet, consectetu elit,")
                .setFont(1, 15).setColor(Color.white).setHorizontalCenter().getLabel());
        grid.add(new LabelBuilder("sed do eiusmod tempor incididunt ut labore et.")
                .setFont(1, 15).setColor(Color.white).setHorizontalCenter().getLabel());

        Panel panel = new Panel(new BorderLayout());
        panel.setOpaque(false);
        panel.add(image);
        panel.add(grid, BorderLayout.SOUTH);

        add(panel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Dimension dimension = getPreferredSize();
        int w = dimension.width, h = dimension.height;

        GradientPaint gp = new GradientPaint(100, 100, new Color(44, 111, 233), 400, 400, new Color(192, 79, 152));
        g2.setPaint(gp);
        g2.fillRect(0, 0, w, h);
    }
}
