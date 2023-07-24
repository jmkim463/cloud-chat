package gui.layout.chatting;

import gui.components.Button;
import gui.components.Frame;
import gui.components.LabelFactory;
import gui.components.Scroll;
import utils.Colors;
import utils.ImageUtils;
import utils.MessageType;
import utils.Utils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class ChatField extends JPanel {

    private final static int MAX_TEXT_LENGTH = 2000;

    private JPanel messagePanel = new JPanel();
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

    class MessageInputField extends JPanel {

        JTextArea textArea = new JTextArea();
        JLabel textLengthLabel = LabelFactory.createLabel("0", 10, Color.lightGray);

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
            panel.add(Utils.coverComponentsFlowlayout(textLengthLabel,
                    LabelFactory.createLabel("/", 10, Color.lightGray),
                    LabelFactory.createLabel(MAX_TEXT_LENGTH + "", 10, Color.lightGray))
                , BorderLayout.WEST);
            panel.add(btn, BorderLayout.EAST);

            add(panel, BorderLayout.NORTH);
            add(scroll);
        }
    }
}
