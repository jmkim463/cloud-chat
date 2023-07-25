package gui.layout.chatting;

import gui.components.LabelBuilder;
import gui.components.Scroll;
import gui.components.Panel;
import utils.Colors;
import utils.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChatRoomList extends Panel {

    private Panel chatRoomList = new Panel();
    private Scroll scroll = new Scroll(chatRoomList);

    private ChatRoom selectedChatRoom = null;

    public ChatRoomList() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout());

        chatRoomList.setLayout(new BoxLayout(chatRoomList, BoxLayout.Y_AXIS));
        chatRoomList.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));

        scroll.setShowThumb(false);

        UserInfo user = new UserInfo();

        add(user, BorderLayout.NORTH);
        add(scroll);
    }

    class UserInfo extends Panel {

        public UserInfo() {
            init();
        }

        private void init() {
            setLayout(new BorderLayout(30, 0));
            setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Colors.getBorderLineColor()));

            add(cover(new JLabel(ImageUtils.changeToCircleImage(80, ImageUtils.getDefaultUserImageIcon())), new JLabel("이름")), BorderLayout.WEST);

        }
    }

    class ChatRoom extends Panel {

        private JLabel nameLabel = new LabelBuilder("방이름").getLabel();
        private JLabel chatLabel = new LabelBuilder("hello world!").setFont(13).setColor(Color.gray).getLabel();
        private JLabel lastChatTimeLabel = new LabelBuilder("00일 전").setFont(10).setColor(Color.gray).getLabel();

        private ActionListener actionListener;

        private boolean isSelected;

        public ChatRoom() {
            init();
        }

        private void init() {
            setLayout(new BorderLayout(30, 0));
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
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    if(actionListener != null) {
                        actionListener.actionPerformed(null);
                    }

                    if(selectedChatRoom != null) {
                        selectedChatRoom.setSelected(false);
                    }

                    setSelected(true);
                    selectedChatRoom = ChatRoom.this;
                }
            });
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
            setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0,
                    isSelected ? new Color(0, 196, 255) : Color.white));

        }
    }


}
