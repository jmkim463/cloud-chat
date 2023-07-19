package gui.layout.chatting;

import gui.components.Scroll;
import utils.ImageUtils;
import utils.Utils;

import javax.swing.*;
import java.awt.*;

public class ChatRoomList extends JPanel {

    JPanel chattingRoomList = new JPanel(new GridLayout(0, 1));

    Scroll scroll = new Scroll(chattingRoomList);

    public ChatRoomList() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout());

        chattingRoomList.add(new ChatRoom());

        add(chattingRoomList);
    }

    class ChatRoom extends JPanel {

        public ChatRoom() {
            setLayout(new BorderLayout());
            setPreferredSize(new Dimension(100, 100));

            JLabel label = new JLabel(ImageUtils.changeToCircleImage(100, new ImageIcon(ImageUtils.getURL("cloud.png"))));
            label.setPreferredSize(new Dimension(100, 100));
            System.out.println(label.getIcon());
            add(label, BorderLayout.WEST);
        }
    }


}
