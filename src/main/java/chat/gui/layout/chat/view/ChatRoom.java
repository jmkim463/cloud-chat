package chat.gui.layout.chat.view;

import chat.gui.components.ImageBuilder;
import chat.gui.components.LabelBuilder;
import chat.gui.components.Panel;
import chat.module.dto.ChatRoomDTO;
import org.intellij.lang.annotations.Flow;

import javax.swing.*;
import java.awt.*;

public class ChatRoom extends Panel {

    private ChatRoomDTO chatroom;

    private JLabel nameLabel = new LabelBuilder("방이름").getLabel();
    private JLabel chatLabel = new LabelBuilder("hello world!").setFont(13).setColor(Color.gray).getLabel();
    private JLabel lastChatTimeLabel = new LabelBuilder("00일 전").setFont(10).setColor(Color.gray).getLabel();

    private boolean isSelected;

    public ChatRoom(ChatRoomDTO chatroom) {
        this.chatroom = chatroom;

        init();
    }

    private void init() {
        setLayout(new BorderLayout(35, 0));
        setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        setSelected(false);

        Panel profileImagesPanel = new Panel(new FlowLayout());

        profileImagesPanel.add(
                new JLabel(new ImageBuilder("default_user", ImageBuilder.ICON).setSize(40, 40).getImageIcon()));

        lastChatTimeLabel.setVerticalTextPosition(JLabel.BOTTOM);
        lastChatTimeLabel.setVerticalAlignment(JLabel.BOTTOM);

        if(chatroom != null) {
            nameLabel.setText(chatroom.getName());
        }

        Panel panel = new Panel(new BorderLayout());
        panel.add(nameLabel);
        panel.add(chatLabel, BorderLayout.SOUTH);

        add(cover(profileImagesPanel, panel.cover()), BorderLayout.WEST);
        add(lastChatTimeLabel, BorderLayout.EAST);
    }

    public ChatRoomDTO getChatroomDTO() {
        return chatroom;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
        setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0,
                isSelected ? new Color(0, 196, 255) : Color.white));

        revalidate();
        repaint();
    }

    public void setChatLabelText(String text) {
        chatLabel.setText(text);
    }

}