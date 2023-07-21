package gui.layout.chatting;

import gui.components.LabelFactory;
import gui.components.Scroll;
import jdk.jshell.execution.Util;
import utils.Colors;
import utils.ImageUtils;
import utils.Utils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChatRoomList extends JPanel {

    private JPanel chatRoomList = new JPanel();
    private Scroll scroll = new Scroll(chatRoomList);

    private ChatRoom selectedChatRoom = null;

    public ChatRoomList() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout());

        chatRoomList.setLayout(new BoxLayout(chatRoomList, BoxLayout.Y_AXIS));
        chatRoomList.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
        for(int i = 0; i < 10; i++) {
            chatRoomList.add(Utils.coverComponentsFlowlayout(new ChatRoom()));
        }

        scroll.setShowThumb(false);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Colors.getBorderLineColor()));

        UserInfo user = new UserInfo();

        add(user, BorderLayout.NORTH);
        add(scroll);
    }

    class UserInfo extends JPanel {

        public UserInfo() {
            init();
        }

        private void init() {
            setLayout(new BorderLayout(30, 0));
            setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Colors.getBorderLineColor()));

            add(Utils.coverComponentsFlowlayout(new JLabel(ImageUtils.changeToCircleImage(80, ImageUtils.getDefaultUserImageIcon())), new JLabel("이름")), BorderLayout.WEST);

        }
    }

    class ChatRoom extends JPanel {

        private JLabel nameLabel = LabelFactory.createLabel("방이름");
        private JLabel chatLabel = LabelFactory.createLabel("hello world!", 13, Color.gray);
        private JLabel lastChatTimeLabel = LabelFactory.createLabel("00일 전", 10, Color.gray);

        private ActionListener actionListener;

        private boolean isSelected;

        public ChatRoom() {
            init();
        }

        private void init() {
            setLayout(new BorderLayout(30, 0));
            setSelected(false);

            int count = 1;
            JPanel profileImagesPanel = new JPanel();
            if(count == 1) {
                profileImagesPanel.add(new JLabel(ImageUtils.changeToCircleImage(40, ImageUtils.getDefaultUserImageIcon())));
            }

            lastChatTimeLabel.setVerticalTextPosition(JLabel.BOTTOM);
            lastChatTimeLabel.setVerticalAlignment(JLabel.BOTTOM);

            JPanel panel = new JPanel(new BorderLayout());
            panel.add(nameLabel);
            panel.add(chatLabel, BorderLayout.SOUTH);

            add(Utils.coverComponentsFlowlayout(profileImagesPanel, panel), BorderLayout.WEST);
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

        public void setActionListener(ActionListener actionListener) {
            this.actionListener = actionListener;
        }
    }


}
