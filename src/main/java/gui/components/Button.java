package gui.components;

import utils.Colors;
import utils.ImageUtils;
import utils.MessageType;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Button extends JLabel {


    private ActionListener actionListener;
    private JTextComponent textComponent;

    private boolean isUseCheckIcon;

    public Button(int w, int h, String text) {
        setText(text);
        setForeground(Color.white);
        setBackground(Colors.getButtonBackgroundColor());
        setPreferredSize(new Dimension(w, h));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(actionListener != null) {
                    if(textComponent != null) {
                        if(textComponent.getText().isBlank()) {
                            return;
                        }
                    }

                    actionListener.actionPerformed(null);

                    revalidate();
                    repaint();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(Colors.getPressBackgroundColor());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(Colors.getButtonBackgroundColor());
            }
        });
    }

    public void setUseCheckIcon(boolean useCheckIcon) {
        isUseCheckIcon = useCheckIcon;
    }

    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    public void setCheckEmptyTextComponent(JTextComponent textComponent) {
        this.textComponent = textComponent;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if(textComponent != null) {
            if(textComponent.getText().isBlank()) {
                setBackground(Color.lightGray);
            } else {
                setBackground(Colors.getButtonBackgroundColor());
            }
        }

        Dimension dimension = getPreferredSize();
        int w = dimension.width, h = dimension.height;

        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, w, h, 25, 25);

        g2.setColor(getForeground());
        g2.setFont(new Font("나눔고딕", 1, 15));

        FontMetrics fontMetrics = g2.getFontMetrics();
        Rectangle rectangle = fontMetrics.getStringBounds(getText(), g2).getBounds();

        int x = (w - rectangle.width) / 2;
        int y = (h - rectangle.height) / 2 + fontMetrics.getAscent();
        int imageSize = 25;

        g2.drawString(getText(), x - 5, y);

        if(isUseCheckIcon) {
            g2.drawImage(ImageUtils.changePNGImageColor("icon/check.png", getForeground())
                    .getImage().getScaledInstance(imageSize, imageSize, Image.SCALE_SMOOTH), w - imageSize - (h - imageSize), 3, null);
        }
    }
}