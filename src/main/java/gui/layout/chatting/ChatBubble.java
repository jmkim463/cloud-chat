package gui.layout.chatting;

import gui.components.LabelFactory;
import utils.MessageType;
import utils.Utils;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class ChatBubble extends JPanel {

    private final static int MAX_LINE_TEXT_COUNT = 40;

    private final static Color ME_BACKGROUND = new Color(208, 227, 237);
    private final static Color OTHER_BACKGROUND = new Color(239, 239, 239);

    public ChatBubble(String text, MessageType messageType) {
        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea(text);
        textArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        textArea.setFont(LabelFactory.getLabelDefaultFont());
        textArea.setOpaque(false);
        textArea.setMinimumSize(new Dimension(0, 0));
        textArea.setSelectionColor(Color.yellow);
        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                e.setKeyChar((char) 0);
            }
        });

        if(textArea.getText().length() > MAX_LINE_TEXT_COUNT) {
            textArea.setLineWrap(true);
            textArea.setColumns(MAX_LINE_TEXT_COUNT);
        }

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                Dimension dimension = getPreferredSize();
                int w = dimension.width, h = dimension.height;

                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, w, h, 25, 25);
            }
        };
        panel.add(textArea);

        String align = null;

        if(messageType == MessageType.Me) {
            panel.setBackground(ME_BACKGROUND);
            align = BorderLayout.EAST;
            setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 10));
        } else if (messageType == MessageType.Other) {
            panel.setBackground(OTHER_BACKGROUND);
            align = BorderLayout.WEST;
            setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 0));
        }

        add(panel, align);
    }
}
