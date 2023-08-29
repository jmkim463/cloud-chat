package chat.gui.layout.friend;

import chat.gui.layout.friend.view.AcceptedFriend;
import chat.gui.layout.friend.view.PendingFriend;
import chat.module.dto.UserDTO;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class FriendPresenter {

    private final FriendModel model;
    private final FriendView view;

    public FriendPresenter(FriendModel model, FriendView view) {
        this.model = model;
        this.view = view;

        init();
    }

    private void init() {

    }

    public void refresh() {
        List<JPanel> acceptedList = new ArrayList<>();
        for(UserDTO userDTO : model.getFriendList()) {
            AcceptedFriend item = new AcceptedFriend(userDTO);
            item.addClickListener(e -> chatFriend(userDTO));
            acceptedList.add(item);
        }

        List<JPanel> pendingList = new ArrayList<>();
        for(UserDTO userDTO : model.getPendingFriendList()) {
            PendingFriend item = new PendingFriend(userDTO);
            item.getButton().setClickEvent(e -> updateStatus(userDTO, 2));
            item.getCancel().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    updateStatus(userDTO, 3);
                }
            });
            pendingList.add(item);
        }

        view.refresh(pendingList, acceptedList);
    }

    public void updateStatus(UserDTO userDTO, int status) {
        model.updateStatus(userDTO.getNo(), status);

        refresh();
    }

    public void chatFriend(UserDTO userDTO) {

    }

}
