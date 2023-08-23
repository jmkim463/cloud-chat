package chat.gui.layout.chat.view;

import chat.gui.components.Font;
import chat.gui.components.ImageBuilder;
import chat.gui.components.LabelBuilder;
import chat.gui.components.Panel;
import chat.module.Storage;
import chat.module.dto.MessageDTO;
import chat.module.dto.UserDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;

public class ChatBubble extends Panel {

    private final static int MAX_LINE_TEXT_COUNT = 40;

    private final static Color ME_BACKGROUND = new Color(208, 227, 237);
    private final static Color OTHER_BACKGROUND = new Color(239, 239, 239);

    public ChatBubble(MessageDTO message) {
        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea(message.getContent());
        textArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        textArea.setFont(new Font());
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

        UserDTO user = (UserDTO) Storage.getInstance().getData(Storage.LOGIN_USER);
        UserDTO sender = message.getSenderDTO();

        JPanel bubble = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5)) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                Dimension dimension = getPreferredSize();
                int w = dimension.width, h = dimension.height;

                g2.setColor(getBackground());
                g2. fillRoundRect(0, 0, w, h, 25, 25);
            }
        };
        bubble.add(textArea);

        if(user.getNo().equals(sender.getNo())) {
            bubble.setBackground(ME_BACKGROUND);
            setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 10));

            add(bubble, BorderLayout.EAST);
        } else {
            bubble.setBackground(OTHER_BACKGROUND);
            setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 0));

            String time = message.getSendAt().split(" ")[1];
            time = time.substring(0, time.lastIndexOf(":"));

            Panel panel = new Panel(new BorderLayout(0, 0));
            panel.add(new LabelBuilder(sender.getName()).setFont(13).setColor(Color.gray).getLabel(), BorderLayout.NORTH);
            panel.add(bubble);
            panel.add(new LabelBuilder(time).setFont(13).setColor(Color.gray).getLabel(), BorderLayout.SOUTH);

            JLabel senderImage = new JLabel(new ImageBuilder(sender.getImageURL(), ImageBuilder.URL).changeCircleImage(50).getImageIcon());
            senderImage.setVerticalAlignment(JLabel.TOP);
            senderImage.setVerticalTextPosition(JLabel.TOP);

            add(cover(senderImage, panel), BorderLayout.WEST);
        }
    }
}
