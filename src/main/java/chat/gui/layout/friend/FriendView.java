package chat.gui.layout.friend;

import chat.gui.components.Panel;
import chat.gui.components.Scroll;
import chat.gui.layout.friend.view.FriendList;
import chat.gui.layout.friend.view.Header;
import chat.module.dto.UserDTO;

import java.awt.*;
import java.util.List;

public class FriendView extends Panel {

    private final Header header;
    private final Scroll scroll;
    private final FriendList friendList;

    public FriendView() {
        header = new Header();
        friendList = new FriendList();
        scroll = new Scroll(friendList);

        init();
    }

    private void init() {
        setLayout(new BorderLayout());

        add(header, BorderLayout.NORTH);
        add(scroll);
    }

    public void refresh(List<UserDTO> pendingList, List<UserDTO> acceptedList) {

        friendList.refreshAcceptedFriendList(acceptedList);
        friendList.refreshPendingFriendList(pendingList);

        revalidate();
        repaint();
    }



}
