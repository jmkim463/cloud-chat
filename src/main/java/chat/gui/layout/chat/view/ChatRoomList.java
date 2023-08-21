package chat.gui.layout.chat.view;

import chat.gui.components.ImageBuilder;
import chat.gui.components.LabelBuilder;
import chat.gui.components.Scroll;
import chat.gui.components.Panel;
import chat.gui.utils.Colors;
import chat.module.dto.UserDTO;
import chat.module.Storage;
import chat.module.dto.ChatRoomDTO;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ChatRoomList extends Panel {

    private Panel chatRoomList = new Panel();
    private Scroll scroll = new Scroll(chatRoomList.cover());

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

    public void setChatRoomList(List<ChatRoomDTO> list) {
        chatRoomList.removeAll();

        for(ChatRoomDTO item : list) {
            ChatRoom room = new ChatRoom(item);
            chatRoomList.add(room);
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

}
