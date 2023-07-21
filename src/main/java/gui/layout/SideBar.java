package gui.layout;

import utils.Colors;
import utils.ImageUtils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class SideBar extends JPanel {

    public SideBar() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        setBackground(new Color(67, 142, 185));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel top = new JPanel(new GridLayout(0, 1, 0, 20));
        JPanel bottom = new JPanel(new GridLayout(0, 1, 0, 20));

        top.setOpaque(false);
        bottom.setOpaque(false);

        top.add(new IconLabel("person"));
        top.add(new IconLabel("chat"));

        bottom.add(new IconLabel("group_add"));
        bottom.add(new IconLabel("setting"));
        bottom.add(new IconLabel("logout"));

        add(top, BorderLayout.NORTH);
        add(bottom, BorderLayout.SOUTH);
    }

    class IconLabel extends JLabel {

        private String name;

        public IconLabel(String name) {
            this.name = name;

            init();
        }

        private void init() {
            ImageIcon icon = new ImageIcon(ImageUtils.changePNGImageColor("icon/" + name + ".png", Color.white)
                    .getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));

            setToolTipText(name);
            setIcon(icon);
        }

        @Override
        public JToolTip createToolTip() {
            JToolTip toolTip = new JToolTip();
            toolTip.setComponent(this);
            toolTip.setBorder(new LineBorder(Color.black));
            toolTip.setBackground(Color.WHITE);
            toolTip.setFont(new Font("나눔고딕", 0, 13));
            toolTip.setForeground(Color.BLACK);
            return toolTip;
        }
    }
}
