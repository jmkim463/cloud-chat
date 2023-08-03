package gui.layout.chatting.view;

import gui.components.LabelBuilder;
import gui.components.Logic;
import gui.components.Panel;
import gui.utils.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChatRoom extends Panel {

    private JLabel nameLabel = new LabelBuilder("방이름").getLabel();
    private JLabel chatLabel = new LabelBuilder("hello world!").setFont(13).setColor(Color.gray).getLabel();
    private JLabel lastChatTimeLabel = new LabelBuilder("00일 전").setFont(10).setColor(Color.gray).getLabel();

    private Logic clickChatRoom;

    private boolean isSelected;

    public ChatRoom() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout(35, 0));
        setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        setSelected(false);

        int count = 1;
        Panel profileImagesPanel = new Panel();
        if(count == 1) {
            profileImagesPanel.add(new JLabel(ImageUtils.changeToCircleImage(40, ImageUtils.getDefaultUserImageIcon())));
        }

        lastChatTimeLabel.setVerticalTextPosition(JLabel.BOTTOM);
        lastChatTimeLabel.setVerticalAlignment(JLabel.BOTTOM);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(nameLabel);
        panel.add(chatLabel, BorderLayout.SOUTH);

        add(cover(profileImagesPanel, panel), BorderLayout.WEST);
        add(lastChatTimeLabel, BorderLayout.EAST);
        setClick(this::clickChatRoom);
    }

    public void setClickChatRoom(Logic clickChatRoom) {
        this.clickChatRoom = clickChatRoom;
    }

    private void clickChatRoom() {
        clickChatRoom.action();
    }

    public Logic getClickChatRoom() {
        return clickChatRoom;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
        setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0,
                isSelected ? new Color(0, 196, 255) : Color.white));

    }


}