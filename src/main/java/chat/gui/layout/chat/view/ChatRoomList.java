package chat.gui.layout.chat.view;

import chat.gui.components.*;
import chat.gui.components.Panel;
import chat.gui.layout.popup.group.GroupApp;
import chat.gui.utils.Colors;
import chat.module.dto.UserDTO;
import chat.module.Storage;
import chat.module.dto.ChatRoomDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ChatRoomList extends Panel {

    private final Panel chatRoomList;
    private final Scroll scroll;
    private final JLabel groupAddLabel;

    public ChatRoomList() {
        chatRoomList = new Panel();
        scroll = new Scroll(chatRoomList.cover());
        groupAddLabel = new JLabel();

        init();
    }

    private void init() {
        setLayout(new BorderLayout());

        chatRoomList.setLayout(new BoxLayout(chatRoomList, BoxLayout.Y_AXIS));
        chatRoomList.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));

        scroll.setShowThumb(false);

        groupAddLabel.setIcon(new ImageBuilder("group_add", ImageBuilder.ICON)
                .changeImageColor(Color.GRAY)
                .setSize(30, 30)
                .getImageIcon());
        groupAddLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GroupApp app = new GroupApp();
                app.open();
            }
        });

        UserInfo user = new UserInfo();

        JPanel header = new JPanel(new BorderLayout());
        header.add(user);
        header.add(cover(FlowLayout.RIGHT, 0, 0, groupAddLabel), BorderLayout.SOUTH);
        header.setBorder(new ShadowBorder(3));

        add(header, BorderLayout.NORTH);
        add(scroll);
    }

    public void moveChatRoomToTop(ChatRoom chatRoom) {
        chatRoomList.remove(chatRoom);
        chatRoomList.add(chatRoom, 0);
    }

    public void refreshChatRoomList(List<ChatRoom> list) {
        chatRoomList.removeAll();

        for(ChatRoom chatRoom : list) {
            chatRoomList.add(chatRoom);
        }

        revalidate();
        repaint();
    }

    class UserInfo extends Panel {

        public UserInfo() {
            init();
        }

        private void init() {
            setLayout(new BorderLayout(30, 0));
            setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Colors.getBorderLineColor()));

            UserDTO userDTO = (UserDTO) Storage.getInstance().getData(Storage.LOGIN_USER);

            JLabel profile = new JLabel(
                    new ImageBuilder(userDTO.getImageURL(), ImageBuilder.URL)
                            .changeCircleImage(70).getImageIcon());
            profile.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));

            JPanel panel = cover(profile, new LabelBuilder(userDTO.getName()).getLabel());
            panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 50));
            add(panel, BorderLayout.WEST);
        }
    }

    public JLabel getGroupAddLabel() {
        return groupAddLabel;
    }
}
