package chat.gui.components;

import chat.gui.utils.Colors;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class Scroll extends JScrollPane {

    private boolean isShowThumb = true;

    public Scroll() {
        init();
    }

    public Scroll(Component component) {
        init();

        setViewportView(component);
    }

    public void setShowThumb(boolean showThumb) {
        isShowThumb = showThumb;
    }

    private void init() {
        setBorder(null);
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JScrollBar bar = getVerticalScrollBar();
        bar.setUnitIncrement(30);
        bar.setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Colors.getBorderLineColor();
                this.trackColor = Color.white;
            }

            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
                if(isShowThumb) {
                    int w = thumbBounds.width / 3;
                    int h = thumbBounds.height;

                    int x = thumbBounds.x + w;
                    int y = thumbBounds.y;

                    Graphics2D g2 = (Graphics2D) g;
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                    g2.setColor(this.thumbColor);
                    g2.fillRoundRect(x, y, w, h, 30, 10);
                }
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
