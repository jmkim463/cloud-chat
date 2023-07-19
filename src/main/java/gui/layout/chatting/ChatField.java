package gui.layout.chatting;

import gui.components.ChatBubble;
import gui.components.Frame;
import gui.components.Scroll;
import utils.ImageUtils;
import utils.MessageType;
import utils.Utils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class ChatField extends JPanel {

    private final static int MAX_TEXT_LENGTH = 2000;

    JPanel messageListPanel = new JPanel();
    JScrollPane scroll = new Scroll(messageListPanel);

    JTextArea textArea = new JTextArea();

    JLabel textCountLabel = new JLabel("0");

    public static void main(String[] args) {
        Frame frame = new Frame();

        ChatField chatField = new ChatField();

        for(int i = 0; i < 20; i++) {
            Random rnd = new Random();

            chatField.addMessage("히히히 안뇽안뇽", rnd.nextInt(2) == 0 ? MessageType.Me : MessageType.Other);
        }

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(chatField);
        panel.add(new ChatRoomList(), BorderLayout.WEST);

        frame.add(panel);

        frame.setVisible(true);
    }

    public ChatField() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout());

        messageListPanel.setLayout(new BoxLayout(messageListPanel, BoxLayout.Y_AXIS));

        add(scroll, BorderLayout.CENTER);
        add(new MessageInputField(), BorderLayout.SOUTH);
    }

    public void addMessage(String text, MessageType messageType) {
        ChatBubble chat = new ChatBubble(text, messageType);
        messageListPanel.add(chat);

        messageListPanel.revalidate();
        messageListPanel.repaint();

        if(isVisible()) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JScrollBar bar = scroll.getVerticalScrollBar();
                    bar.setValue(bar.getMaximum());
                }
            });
        }
    }

    class MessageInputField extends JPanel {

        public MessageInputField() {
            init();
        }

        private void init() {
            setLayout(new BorderLayout(10, 10));
            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            Scroll scroll = new Scroll(textArea);
            scroll.setPreferredSize(new Dimension(0, 100));
            scroll.setBorder(new LineBorder(new Color(227, 227, 227)));

            textArea.setLineWrap(true);
            textArea.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    int len = Integer.parseInt(textCountLabel.getText());
                    if(len >= MAX_TEXT_LENGTH) {
                        e.setKeyChar((char) 0);
                        return;
                    }

                    textCountLabel.setText(textArea.getText().length() + "");

                    ChatField.this.revalidate();
                    ChatField.this.repaint();
                }
            });

            JLabel label1 = new JLabel("/");
            JLabel label2 = new JLabel(MAX_TEXT_LENGTH + "");

            textCountLabel.setFont(new Font("나눔고딕", 0, 10));
            label1.setFont(new Font("나눔고딕", 0, 10));
            label2.setFont(new Font("나눔고딕", 0, 10));

            textCountLabel.setForeground(Color.lightGray);
            label1.setForeground(Color.lightGray);
            label2.setForeground(Color.lightGray);

            JPanel panel = new JPanel(new BorderLayout());
            panel.add(Utils.coverComponentsFlowlayout(textCountLabel, label1, label2), BorderLayout.WEST);
            panel.add(new SendButton(), BorderLayout.EAST);

            add(panel, BorderLayout.NORTH);
            add(scroll);
        }
    }

    class SendButton extends JLabel {
        private final static int WIDTH = 100;
        private final static int HEIGHT = 35;

        private final static String TEXT = "전송";

        private final static Color BACKGROUND = new Color(25, 167, 206);
        private final static Color PRESS_BACKGROUND = new Color(20, 108, 148);

        public SendButton() {
            setPreferredSize(new Dimension(WIDTH, HEIGHT));
            setBackground(BACKGROUND);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(!textArea.getText().isEmpty()) {
                        addMessage(textArea.getText(), MessageType.Me);
                        textCountLabel.setText("0");
                        textArea.setText("");
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    setBackground(PRESS_BACKGROUND);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    setBackground(BACKGROUND);
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            Color foreground = Color.white;
            Color background = textArea.getText().isEmpty() ? Color.lightGray : getBackground();

            g2.setColor(background);
            g2.fillRoundRect(0, 0, WIDTH, HEIGHT, 25, 25);

            g2.setColor(foreground);
            g2.setFont(new Font("나눔고딕", 1, 15));

            FontMetrics fontMetrics = g2.getFontMetrics();
            Rectangle rectangle = fontMetrics.getStringBounds(TEXT, g2).getBounds();

            int x = (WIDTH - rectangle.width) / 2;
            int y = (HEIGHT - rectangle.height) / 2 + fontMetrics.getAscent();
            int imageSize = 25;

            g2.drawString(TEXT, x - 5, y);

            g2.drawImage(ImageUtils.changePNGImageColor("check.png", foreground)
                    .getImage().getScaledInstance(imageSize, imageSize, Image.SCALE_SMOOTH), WIDTH - imageSize - 3, 3, null);
        }
    }
}
