package gui.layout.chat.view;

import gui.components.Scroll;
import gui.components.Panel;
import gui.utils.Colors;
import gui.utils.ImageUtils;
import module.dto.UserDTO;
import module.Storage;
import module.dto.ChatRoomDTO;

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
            ChatRoom room = new ChatRoom();



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

            Storage storage = Storage.getInstance();

            UserDTO userDTO = (UserDTO) Storage.getInstance().getAttribute("userDTO");

            add(cover(
                    new JLabel(ImageUtils.changeToCircleImage(80, ImageUtils.getURLImageIcon(userDTO.getImageURL()))),
                    new JLabel(userDTO.getName())), BorderLayout.WEST);
        }
    }

}
