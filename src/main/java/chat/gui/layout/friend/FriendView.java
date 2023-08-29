package chat.gui.layout.friend;

import chat.gui.components.Panel;
import chat.gui.components.Scroll;
import chat.gui.layout.friend.view.FriendGroup;
import chat.gui.layout.friend.view.FriendHeader;
import chat.gui.layout.friend.view.LoginUser;
import chat.gui.layout.friend.view.PendingFriend;
import chat.module.dto.UserDTO;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FriendView extends Panel {

    private final FriendHeader header;
    private final Scroll scroll;

    private final FriendGroup accepted;
    private final FriendGroup pending;

    public FriendView() {
        header = new FriendHeader();
        scroll = new Scroll();

        accepted = new FriendGroup("친구");
        pending = new FriendGroup("친구 추가 대기");

        init();
    }

    private void init() {
        setLayout(new BorderLayout(0, 5));

        Panel viewport = new Panel(new BorderLayout());
        viewport.add(accepted, BorderLayout.NORTH);
        viewport.add(pending);

        Panel panel = new Panel(new BorderLayout(0, 20));
        panel.add(new LoginUser(), BorderLayout.NORTH);
        panel.add(viewport);

        scroll.setViewportView(panel);

        add(header, BorderLayout.NORTH);
        add(scroll);
    }

    public void refresh(List<JPanel> pending, List<JPanel> accepted) {
        this.pending.setList(pending);
        this.accepted.setList(accepted);

        revalidate();
        repaint();
    }



}
