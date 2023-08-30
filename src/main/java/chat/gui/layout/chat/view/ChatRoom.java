package chat.gui.layout.chat.view;

import chat.gui.components.*;
import chat.gui.components.Font;
import chat.gui.components.Panel;
import chat.module.RetrofitUtils;
import chat.module.dto.ChatRoomDTO;
import chat.module.dto.MessageDTO;
import chat.module.dto.UserDTO;
import org.intellij.lang.annotations.Flow;

import javax.swing.*;
import java.awt.*;

public class ChatRoom extends Panel {

    private final ChatRoomDTO chatroom;

    private final JLabel nameLabel;
    private final JLabel chatLabel;
    private final JLabel lastChatTimeLabel;
    private final JLabel notReadChatCountLabel;

    private boolean isSelected;

    public ChatRoom(ChatRoomDTO chatroom) {
        this.chatroom = chatroom;

        nameLabel = new LabelBuilder(chatroom.getName()).getLabel();
        chatLabel = new LabelBuilder(chatroom.getLastChat()).setFont(13).setColor(Color.gray).getLabel();
        lastChatTimeLabel = new LabelBuilder(chatroom.getLastAt()).setFont(10).setColor(Color.gray).getLabel();
        notReadChatCountLabel = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.setColor(Color.red);
                g2.fillOval(0, 0, getWidth(), getHeight());

                super.paintComponent(g2);
            }
        };

        init();
    }

    private void init() {
        setPreferredSize(new Dimension(255, 65));
        setLayout(new BorderLayout(0, 0));
        setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        setSelected(false);

        Panel profileImagesPanel = new Panel(new FlowLayout()) {
            @Override
            public JToolTip createToolTip() {
                return new ToolTip(this);
            }
        };

        if(chatroom.getUserIdList() != null) {
            String[] split = chatroom.getUserIdList().split(",");

            int imageSize = 50;

            if(split.length > 2) {
                imageSize = 28;

                profileImagesPanel.setLayout(new GridLayout(2, 2, 3, 3));
            }

            for(int i = 0; i < 4 && i < split.length; i++) {
                JLabel image = new JLabel(new ImageBuilder(RetrofitUtils.getBaseUrl() + "/api/user/image?id=" + split[i], ImageBuilder.URL).changeCircleImage(imageSize).getImageIcon());
                profileImagesPanel.add(image);
            }
        }

        if(chatroom.getUserNameList() != null) {
            String[] split = chatroom.getUserNameList().split(",");

            String tip = "";
            for(String item : split) {
                tip += item + "<br>";
            }

            profileImagesPanel.setToolTipText("<html>" + tip + "</html>");
        }

        lastChatTimeLabel.setVerticalTextPosition(JLabel.BOTTOM);
        lastChatTimeLabel.setVerticalAlignment(JLabel.BOTTOM);

        notReadChatCountLabel.setPreferredSize(new Dimension(10, 10));
        notReadChatCountLabel.setForeground(Color.white);
        notReadChatCountLabel.setFont(new Font(1, 8));
        notReadChatCountLabel.setHorizontalAlignment(JLabel.CENTER);
        notReadChatCountLabel.setHorizontalTextPosition(JLabel.CENTER);
        notReadChatCountLabel.setVisible(false);

        if(chatroom != null) {
            nameLabel.setText(chatroom.getName());
        }

        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        p.add(nameLabel);
        p.add(cover(notReadChatCountLabel));

        Panel panel = new Panel(new BorderLayout());
        panel.add(p);
        panel.add(chatLabel, BorderLayout.SOUTH);

        add(cover(profileImagesPanel, panel.cover()), BorderLayout.WEST);
        add(lastChatTimeLabel, BorderLayout.EAST);
    }

    public void countNotRead() {
        int cnt = (notReadChatCountLabel.getText().isEmpty() ? 0 : Integer.parseInt(notReadChatCountLabel.getText())) + 1;

        notReadChatCountLabel.setText(cnt + "");
        notReadChatCountLabel.setVisible(true);
    }

    public void refresh(String content, String sendAt) {
        chatLabel.setText(content);
        lastChatTimeLabel.setText(sendAt);
    }

    public ChatRoomDTO getChatroomDTO() {
        return chatroom;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
        setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0,
                isSelected ? new Color(0, 196, 255) : Color.white));

        if(isSelected) {
            notReadChatCountLabel.setText("");
            notReadChatCountLabel.setVisible(false);
        }

        revalidate();
        repaint();
    }

}