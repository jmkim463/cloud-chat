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
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;

public class ChatBubble extends Panel {

    private final static int MAX_LINE_TEXT_COUNT = 40;
    private final static int MAX_IMAGE_WIDTH = 350;

    private final static Color ME_BACKGROUND = new Color(208, 227, 237);
    private final static Color OTHER_BACKGROUND = new Color(239, 239, 239);

    private final MessageDTO messageDTO;
    private final int senderType;

    public ChatBubble(MessageDTO messageDTO) {
        this.messageDTO = messageDTO;

        UserDTO user = (UserDTO) Storage.getInstance().getData(Storage.LOGIN_USER);
        UserDTO sender = messageDTO.getSenderDTO();
        if(user.getNo().equals(sender.getNo())) {
            senderType = 0;
        } else {
            senderType = 1;
        }

        init();
    }

    private void init() {
        setLayout(new BorderLayout());

        JComponent content = getContentComponent();

        if(senderType == 0) {
            setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 10));
            add(content, BorderLayout.EAST);
        } else {
            setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 0));

            String time = messageDTO.getSendAt().split(" ")[1];
            time = time.substring(0, time.lastIndexOf(":"));

            Panel panel = new Panel(new BorderLayout(0, 0));
            panel.add(new LabelBuilder(messageDTO.getSenderDTO().getName()).setFont(13).setColor(Color.gray).getLabel(), BorderLayout.NORTH);
            panel.add(content);
            panel.add(new LabelBuilder(time).setFont(13).setColor(Color.gray).getLabel(), BorderLayout.SOUTH);

            JLabel senderImage = new JLabel(new ImageBuilder(messageDTO.getSenderDTO().getImageURL(), ImageBuilder.URL).changeCircleImage(50).getImageIcon());
            senderImage.setVerticalAlignment(JLabel.TOP);
            senderImage.setVerticalTextPosition(JLabel.TOP);

            add(cover(senderImage, panel), BorderLayout.WEST);
        }
    }

    public JComponent getContentComponent() {
        if(MessageDTO.isImageMessage(messageDTO.getContent())) {
            return getImageContentComponent();
        } else {
            return getTextContentComponent();
        }
    }

    public JComponent getImageContentComponent() {
        ImageIcon image = new ImageBuilder(messageDTO.getImageURL(), ImageBuilder.URL).getImageIcon();
        int w = image.getIconWidth(), h = image.getIconHeight();

        double scale = MAX_IMAGE_WIDTH / (double) w;

        w *= scale;
        h *= scale;

        Graphics2D g2;

        BufferedImage bi1 = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        g2 = bi1.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.red);
        g2.fillRoundRect(0, 0, w, h, 30, 30);
        g2.drawRoundRect(0, 0, w, h, 30, 30);
        g2.dispose();

        BufferedImage bi2 = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        g2 = bi2.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawImage(new ImageIcon(image.getImage().getScaledInstance(w, h, Image.SCALE_REPLICATE)).getImage(), 0, 0, null);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN));
        g2.drawImage(bi1, 0, 0, null);
        g2.dispose();

        image = new ImageIcon(bi2);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panel.add(new JLabel(image));

        return panel;
    }

    public JComponent getTextContentComponent() {
        JTextArea textArea = new JTextArea(messageDTO.getContent());
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

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5)) {
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
        panel.setBackground(senderType == 0 ? ME_BACKGROUND : OTHER_BACKGROUND);
        panel.add(textArea);

        return panel;
    }
}
