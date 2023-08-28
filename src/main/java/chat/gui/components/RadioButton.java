package chat.gui.components;

import chat.gui.utils.Colors;
import org.intellij.lang.annotations.Flow;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicToggleButtonUI;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RadioButton extends JToggleButton {

    private final JLabel label;
    private final CircleButton circleButton;

    public RadioButton() {
        label = new LabelBuilder("").setFont(13).getLabel();
        circleButton = new CircleButton();

        init();
    }

    public RadioButton(String text) {
        this();
        label.setText(text);
    }

    private void init() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        setModel(model);
        setBorderPainted(false);
        setBackground(Color.white);
        setUI(new BasicToggleButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {}
        });

        Panel panel = new Panel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        panel.add(circleButton);
        panel.add(label);

        add(panel);
    }

    public void setText(String text) {
        label.setText(text);
    }

    public void addItemListener(ItemListener itemListener) {
        model.addItemListener(itemListener);
    }

    class CircleButton extends JPanel {

        private final static int SIZE = 15;
        private final static int WIDTH = 2;
        private Color color = Colors.getButtonBackgroundColor();

        public CircleButton() {
            init();
        }

        private void init() {
            setPreferredSize(new Dimension(SIZE + WIDTH + 1, SIZE + WIDTH + 1));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setColor(color);
            g2.setStroke(new BasicStroke(WIDTH));

            g2.drawOval(1, 1, SIZE, SIZE);

            if(model.isSelected()) {
                g2.fillOval(5, 5, 8, 8);
            }
        }
    }

}
