package chat.gui.layout.friend;

import chat.module.dto.UserDTO;

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
        List<UserDTO> acceptedList = model.getFriendList();
        List<UserDTO> pendingList = model.getPendingFriendList();

        view.refresh(pendingList, acceptedList);
    }

}
