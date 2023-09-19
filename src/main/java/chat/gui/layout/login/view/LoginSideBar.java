package chat.gui.layout.login.view;

import chat.gui.components.ImageBuilder;
import chat.gui.components.LabelBuilder;
import chat.gui.components.Panel;

import javax.swing.*;
import java.awt.*;

public class LoginSideBar extends Panel {

    private final Color color1 = new Color(56, 154, 229);
    private final Color color2 = new Color(102, 177, 235);

    public LoginSideBar() {
        init();
    }

    private void init() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 150));
        setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        JLabel image = new JLabel(
                new ImageBuilder("login-image", ImageBuilder.RESOURCES)
                        .setSize(400, 275).getImageIcon());

        Panel grid = new Panel(new GridLayout(0, 1, 0, 0));
        grid.setOpaque(false);
        grid.setBorder(BorderFactory.createEmptyBorder(50, 0, 0 ,0));

        grid.add(new LabelBuilder(" ")
                .setFont(1, 15).setColor(Color.white).setHorizontalCenter().getLabel());
        grid.add(new LabelBuilder(" ")
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

        GradientPaint gp = new GradientPaint(100, 100, color1, 400, 400, color2);
        g2.setPaint(gp);
        g2.fillRect(0, 0, w, h);
    }
}
