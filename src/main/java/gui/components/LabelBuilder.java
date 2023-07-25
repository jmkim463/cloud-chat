package gui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LabelBuilder {

    private JLabel label = new JLabel();
    private ActionListener clickListener;

    public LabelBuilder(ImageIcon icon) {
        label.setIcon(icon);
    }

    public LabelBuilder(String text) {
        label.setText(text);
        label.setFont(new Font());
    }

    public LabelBuilder setFont(int size) {
        label.setFont(new Font(size));
        return this;
    }

    public LabelBuilder setFont(int style, int size) {
        label.setFont(new Font(style, size));
        return this;
    }

    public LabelBuilder setFont(String name, int style, int size) {
        label.setFont(new Font(name, style, size));
        return this;
    }

    public LabelBuilder setHorizontalCenter() {
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        return this;
    }

    public LabelBuilder setColor(Color color) {
        label.setForeground(color);
        return this;
    }

    public LabelBuilder setClickListener(ActionListener clickListener) {
        if(label.getMouseListeners().length == 0) {
            label.addMouseListener(new MouseListener());
            System.out.println("test");
        }

        this.clickListener = clickListener;
        return this;
    }

    public JLabel getLabel() {
        return label;
    }

    class MouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(clickListener != null) {
                clickListener.actionPerformed(null);
            }
        }
    }
}
