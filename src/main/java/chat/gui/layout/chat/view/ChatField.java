package chat.gui.layout.chat.view;

import chat.gui.components.button.Button;
import chat.gui.components.LabelBuilder;
import chat.gui.components.Panel;
import chat.gui.components.Scroll;
import chat.gui.utils.Colors;
import chat.module.dto.MessageDTO;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ChatField extends Panel {

    private final static int MAX_TEXT_LENGTH = 2000;

    private final Panel messagePanel;
    private final JScrollPane scroll;
    private final MessageInputField inputField;
    private final JTextArea textArea;
    private final Button messageSendButton;

    public ChatField() {
        textArea = new JTextArea();
        messagePanel = new Panel();
        messageSendButton = new Button(150, 35, "전송");
        scroll = new Scroll();
        inputField = new MessageInputField();

        init();
    }

    private void init() {
        setLayout(new BorderLayout());

        Panel scrollViewPort = new Panel(new BorderLayout());
        scrollViewPort.add(messagePanel, BorderLayout.NORTH);
        scrollViewPort.add(new Panel());
        scroll.setViewportView(scrollViewPort);

        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));

        add(scroll, BorderLayout.CENTER);
        add(inputField, BorderLayout.SOUTH);
    }

    public Button getMessageSendButton() {
        return messageSendButton;
    }

    public void addMessage(MessageDTO messageDTO) {
        ChatBubble chat = new ChatBubble(messageDTO);

        messagePanel.add(chat);
    }

    public void scrollToBottom() {
        SwingUtilities.invokeLater(() -> {
            JScrollBar bar = scroll.getVerticalScrollBar();
            bar.setValue(bar.getMaximum());

            revalidate();
            repaint();
        });
    }

    public void initInputField() {
        textArea.setText("");
        inputField.textLengthLabel.setText("0");
    }

    public void clearMessageScroll() {
        messagePanel.removeAll();

        revalidate();
        repaint();
    }

    class MessageInputField extends Panel {
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

            messageSendButton.setCheckEmptyTextComponent(new JTextComponent[] {textArea});
            messageSendButton.setUseCheckIcon(true);

            JPanel panel = new JPanel(new BorderLayout());
            panel.add(cover(textLengthLabel,
                    new LabelBuilder("/").setFont(10).setColor(Color.lightGray).getLabel(),
                    new LabelBuilder(MAX_TEXT_LENGTH + "").setFont(10).setColor(Color.lightGray).getLabel())
                , BorderLayout.WEST);
            panel.add(messageSendButton, BorderLayout.EAST);

            add(panel, BorderLayout.NORTH);
            add(scroll);
        }
    }

    public String getMessage() {
        return textArea.getText();
    }

}
