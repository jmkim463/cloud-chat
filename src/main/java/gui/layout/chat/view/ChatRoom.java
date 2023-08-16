package gui.layout.chat.view;

import gui.components.EventObserver;
import gui.components.LabelBuilder;
import gui.components.Panel;
import gui.utils.ImageUtils;
import module.dto.ChatRoomDTO;

import javax.swing.*;
import java.awt.*;

public class ChatRoom extends Panel {

    private ChatRoomDTO chatroom;

    private JLabel nameLabel = new LabelBuilder("방이름").getLabel();
    private JLabel chatLabel = new LabelBuilder("hello world!").setFont(13).setColor(Color.gray).getLabel();
    private JLabel lastChatTimeLabel = new LabelBuilder("00일 전").setFont(10).setColor(Color.gray).getLabel();

    private EventObserver observer;

    private boolean isSelected;

    public ChatRoom(ChatRoomDTO chatroom) {
        this.chatroom = chatroom;

        init();
    }

    private void init() {
        setLayout(new BorderLayout(35, 0));
        setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        setSelected(false);

        Panel profileImagesPanel = new Panel(new GridLayout(2, 2));

        profileImagesPanel.add(new JLabel(ImageUtils.changeToCircleImage(40, ImageUtils.getDefaultUserImageIcon())));

        lastChatTimeLabel.setVerticalTextPosition(JLabel.BOTTOM);
        lastChatTimeLabel.setVerticalAlignment(JLabel.BOTTOM);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(nameLabel);
        panel.add(chatLabel, BorderLayout.SOUTH);

        add(cover(profileImagesPanel, panel), BorderLayout.WEST);
        add(lastChatTimeLabel, BorderLayout.EAST);
        setClick(e -> {
            observer.execute();
        });
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
        setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0,
                isSelected ? new Color(0, 196, 255) : Color.white));

    }


}