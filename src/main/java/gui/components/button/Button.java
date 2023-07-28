package gui.components.button;

import gui.utils.ImageUtils;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.*;

public class Button extends JLabel {

    private ButtonStyle style = ButtonStyle.Primary;

    private ActionListener actionListener;
    private JTextComponent[] textComponent;

    private boolean isUseCheckIcon;

    private String text;
    private int w, h;

    public Button(int w, int h, String text) {
        this.text = text;
        this.w = w;
        this.h = h;
        init();
    }

    private void init() {
        setText(text);
        setFont(new gui.components.Font(1, 15));
        setForeground(style.getForeground());
        setBackground(style.getBackground());
        setPreferredSize(new Dimension(w, h));
        addMouseListener(new ClickListener());
    }

    public Button setFont(int size) {
        java.awt.Font font = getFont();
        setFont(new gui.components.Font(font.getName(), font.getStyle(), size));
        return this;
    }

    public Button setStyle(ButtonStyle style) {
        this.style = style;

        setBackground(style.getBackground());
        setForeground(style.getForeground());

        return this;
    }

    public void setUseCheckIcon(boolean useCheckIcon) {
        isUseCheckIcon = useCheckIcon;
    }

    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    public void setCheckEmptyTextComponent(JTextComponent... textComponent) {
        this.textComponent = textComponent;

        for(JTextComponent text : textComponent) {
            text.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    Button.this.revalidate();
                    Button.this.repaint();
                }
            });
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if(textComponent != null) {
            if(Color.lightGray.equals(getBackground())) {
                setBackground(style.getBackground());
            }

            for(JTextComponent text : textComponent) {
                if(text.getText().isEmpty()) {
                    setBackground(Color.lightGray);
                }
            }
        }

        Dimension dimension = getPreferredSize();
        int w = dimension.width, h = dimension.height;

        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, w, h, 25, 25);

        g2.setColor(getForeground());
        g2.setFont(getFont());

        FontMetrics fontMetrics = g2.getFontMetrics();
        Rectangle rectangle = fontMetrics.getStringBounds(getText(), g2).getBounds();

        int x = (w - rectangle.width) / 2;
        int y = (h - rectangle.height) / 2 + fontMetrics.getAscent();
        int imageSize = 25;

        g2.drawString(getText(), x - (isUseCheckIcon ? 5 : 0), y);

        if(isUseCheckIcon) {
            g2.drawImage(ImageUtils.changePNGImageColor("icon/check.png", getForeground())
                    .getImage().getScaledInstance(imageSize, imageSize, Image.SCALE_SMOOTH), w - imageSize - (h - imageSize), 3, null);
        }
    }

    class ClickListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(textComponent != null) {
                for(JTextComponent text : textComponent) {
                    if(text.getText().isEmpty()) {
                        return;
                    }
                }
            }

            if(actionListener != null) {
                actionListener.actionPerformed(null);
            }

            revalidate();
            repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            setBackground(style.getPressBackground());
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            setBackground(style.getBackground());
        }
    }
}