package chat.gui.layout.sidebar.view;

import chat.gui.components.ImageBuilder;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuIcon extends JLabel {

    private String name;

    public MenuIcon(String name) {
        this.name = name;

        init();
    }

    private void init() {
        ImageIcon icon = new ImageBuilder(name, ImageBuilder.ICON).setSize(30, 30).changeImageColor(Color.WHITE).getImageIcon();

        setToolTipText(name);
        setOpaque(false);
        setIcon(icon);
    }

    public void addClickListener(ActionListener actionListener) {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                actionListener.actionPerformed(null);
            }
        });
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
