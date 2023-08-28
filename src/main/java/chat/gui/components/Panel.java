package chat.gui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Panel extends JPanel {

    private ActionListener click;

    public Panel() {

    }

    public Panel(LayoutManager layout) {
        setLayout(layout);
    }

    public JPanel getEmpty(int height) {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(1, height));
        return panel;
    }

    public JPanel getEmpty(int width, int height) {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(width, height));
        return panel;
    }

    public JPanel cover() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(this);
        return panel;
    }

    public JPanel cover(int align) {
        JPanel panel = new JPanel(new FlowLayout(align));
        panel.add(this);
        return panel;
    }

    public JPanel cover(Component...components) {
        JPanel panel = new JPanel(new FlowLayout());
        for(Component obj : components) {
            panel.add(obj);
        }
        return panel;
    }

    public JPanel cover(int align, int hgap, int vgap, Component...components) {
        JPanel panel = new JPanel(new FlowLayout(align, hgap, vgap));
        for(Component obj : components) {
            panel.add(obj);
        }
        return panel;
    }

    public void setClick(ActionListener actionListener) {
        if(getMouseListeners().length == 0) {
            addMouseListener(new MouseListener());
        }

        this.click = actionListener;
    }

    class MouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(click != null) {
                click.actionPerformed(null);
            }
        }
    }
}
