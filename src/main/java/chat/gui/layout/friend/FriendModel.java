package chat.gui.layout.friend;

import chat.module.RetrofitUtils;
import chat.module.Storage;
import chat.module.dto.UserDTO;
import chat.module.service.FriendService;
import lombok.RequiredArgsConstructor;

import java.util.List;

public class FriendModel {

    private final FriendService service;

    public FriendModel() {
        service = RetrofitUtils.createService(FriendService.class);
    }

    public List<UserDTO> getFriendList() {
        UserDTO user = (UserDTO) Storage.getInstance().getData(Storage.LOGIN_USER);

        List<UserDTO> list = RetrofitUtils.getCallBody(service.getFriendList(user.getNo()));

        return list;
    }

    public List<UserDTO> getPendingFriendList() {
        UserDTO user = (UserDTO) Storage.getInstance().getData(Storage.LOGIN_USER);

        List<UserDTO> list = RetrofitUtils.getCallBody(service.getPendingFriendList(user.getNo()));

        return list;
    }

}

