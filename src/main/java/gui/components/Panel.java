package gui.components;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

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

    public JPanel cover() {
        JPanel panel = new JPanel(new FlowLayout());
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

}
