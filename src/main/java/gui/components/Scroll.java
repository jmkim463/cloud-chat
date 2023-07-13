package gui.components;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class Scroll extends JScrollPane {

    public static void main(String[] args) {
        Frame frame = new Frame();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        for(int i = 0; i < 100; i++) {
            panel.add(new JLabel("테스트 " + i));
        }

        frame.add(new Scroll(panel));

        frame.setVisible(true);
    }

    public Scroll(Component component) {
        setViewportView(component);

        init();
    }

    private void init() {
        setBorder(null);

        JScrollBar bar = getVerticalScrollBar();
        bar.setUnitIncrement(30);
        bar.setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.lightGray;
                this.trackColor = Color.white;
            }

            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
                int w = thumbBounds.width / 2;
                int h = thumbBounds.height;

                int x = thumbBounds.x;
                int y = thumbBounds.y;

                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.setColor(this.thumbColor);
                g2.fillRoundRect(x, y, w, h, 30, 10);
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                JButton btn = new JButton();
                btn.setMaximumSize(new Dimension(0, 0));
                btn.setMinimumSize(new Dimension(0, 0));
                btn.setPreferredSize(new Dimension(0, 0));
                return btn;
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                JButton btn = new JButton();
                btn.setMaximumSize(new Dimension(0, 0));
                btn.setMinimumSize(new Dimension(0, 0));
                btn.setPreferredSize(new Dimension(0, 0));
                return btn;
            }
        });
    }
}
