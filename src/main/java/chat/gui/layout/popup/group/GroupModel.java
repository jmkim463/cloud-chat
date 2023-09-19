package chat.gui.layout.popup.group;

import chat.module.RetrofitUtils;
import chat.module.Storage;
import chat.module.dto.ChatRoomDTO;
import chat.module.dto.UserDTO;
import chat.module.service.ChatService;
import chat.module.service.FriendService;

import javax.swing.*;
import java.util.List;

public class GroupModel {

    private final FriendService friendService;

    private final ChatService chatService;

    public GroupModel() {
        friendService = RetrofitUtils.createService(FriendService.class);
        chatService = RetrofitUtils.createService(ChatService.class);

        init();
    }

    private void init() {

    }

    public List<UserDTO> getFriendList() {
        Long no = ((UserDTO) Storage.getInstance().getData(Storage.LOGIN_USER)).getNo();

        List<UserDTO> list = RetrofitUtils.getCallBody(friendService.getFriendList(no));

        return list;
    }

    public void save(String name, List<Long> list) {
        ChatRoomDTO chatroom = ChatRoomDTO.builder()
                .name(name)
                .participants(list).build();

        RetrofitUtils.execute(chatService.saveGroupChatRoom(chatroom));
    }

}
