package chat.gui.layout.friend;

import chat.module.RetrofitUtils;
import chat.module.Storage;
import chat.module.dto.ChatRoomDTO;
import chat.module.dto.UserDTO;
import chat.module.service.ChatService;
import chat.module.service.FriendService;

import java.util.List;

public class FriendModel {

    private final FriendService friendService;

    private final ChatService chatService;

    public FriendModel() {
        friendService = RetrofitUtils.createService(FriendService.class);
        chatService = RetrofitUtils.createService(ChatService.class);
    }

    public List<UserDTO> getFriendList() {
        UserDTO user = (UserDTO) Storage.getInstance().getData(Storage.LOGIN_USER);

        List<UserDTO> list = RetrofitUtils.getCallBody(friendService.getFriendList(user.getNo()));

        return list;
    }

    public List<UserDTO> getPendingFriendList() {
        UserDTO user = (UserDTO) Storage.getInstance().getData(Storage.LOGIN_USER);

        List<UserDTO> list = RetrofitUtils.getCallBody(friendService.getPendingFriendList(user.getNo()));

        return list;
    }

    public void updateStatus(Long userNo1, int status) {
        Long userNo2 = ((UserDTO) Storage.getInstance().getData(Storage.LOGIN_USER)).getNo();

        RetrofitUtils.getCallBody(friendService.updateStatus(userNo1, userNo2, status));
    }

    public ChatRoomDTO getPrivateChatroom(Long userNo1, Long userNo2) {
        ChatRoomDTO chatRoomDTO = RetrofitUtils.getCallBody(chatService.selectPrivateChatRoom(userNo1, userNo2));

        return chatRoomDTO;
    }

}

