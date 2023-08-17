package chat.gui.layout.chat;

import chat.module.RetrofitUtils;
import chat.module.service.UserService;

public class ChatModel {

    private static UserService service;

    static {
        service = RetrofitUtils.createService(UserService.class);
    }

//    public List<ChatRoomDTO> getChatRoomListAll() {
//        ChatService service = RetrofitUtils.createService(ChatService.class);
//
//        UserDTO userDTO = (UserDTO) Storage.getInstance().getAttribute("userDTO");
//
//        List<ChatRoomDTO> list = RetrofitUtils.getCallBody(service.getUserRoomListAll(userDTO.getNo()));
//
//        return list;
//    }

}
