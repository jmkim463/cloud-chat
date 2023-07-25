package gui.layout.chatting;

import gui.components.Button;
import gui.components.LabelBuilder;
import gui.components.Panel;
import gui.components.Scroll;
import utils.Colors;
import utils.MessageType;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ChatField extends Panel {

    private final static int MAX_TEXT_LENGTH = 2000;

    private Panel messagePanel = new Panel();
    private JScrollPane scroll = new Scroll(messagePanel);
    private MessageInputField inputField = new MessageInputField();

    public ChatField() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout());

        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));

        add(scroll, BorderLayout.CENTER);
        add(inputField, BorderLayout.SOUTH);
    }

    public void addMessage(String text, MessageType messageType) {
        ChatBubble chat = new ChatBubble(text, messageType);
        messagePanel.add(chat);
    }

    public void sendMessage(String text) {
        addMessage(text, MessageType.Me);

        messagePanel.revalidate();
        messagePanel.repaint();

        scrollToBottom();
    }

    public void scrollToBottom() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JScrollBar bar = scroll.getVerticalScrollBar();
                bar.setValue(bar.getMaximum());
            }
        });
    }

    public void initInputField() {
        inputField.textArea.setText("");
        inputField.textLengthLabel.setText("0");
    }

    class MessageInputField extends Panel {

        JTextArea textArea = new JTextArea();
        JLabel textLengthLabel = new LabelBuilder("0").setFont(10).setColor(Color.lightGray).getLabel();

        public MessageInputField() {
            init();
        }

        private void init() {
            setLayout(new BorderLayout(10, 10));
            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            textArea.setLineWrap(true);
            textArea.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    int len = Integer.parseInt(textLengthLabel.getText());
                    if(len >= MAX_TEXT_LENGTH) {
                        e.setKeyChar((char) 0);
                        return;
                    }

                    textLengthLabel.setText(textArea.getText().length() + "");
                }
            });

            Scroll scroll = new Scroll(textArea);
            scroll.setPreferredSize(new Dimension(0, 100));
            scroll.setBorder(new LineBorder(Colors.getBorderLineColor()));

            Button btn = new Button(150, 35, "전송");
            btn.setCheckEmptyTextComponent(new JTextComponent[] {textArea});
            btn.setUseCheckIcon(true);
            btn.setActionListener(e -> {
                sendMessage(textArea.getText());
                initInputField();
            });

            JPanel panel = new JPanel(new BorderLayout());
            panel.add(cover(textLengthLabel,
                    new LabelBuilder("/").setFont(10).setColor(Color.lightGray).getLabel(),
                    new LabelBuilder(MAX_TEXT_LENGTH + "").setFont(10).setColor(Color.lightGray).getLabel())
                , BorderLayout.WEST);
            panel.add(btn, BorderLayout.EAST);

            add(panel, BorderLayout.NORTH);
            add(scroll);
        }
    }
}
