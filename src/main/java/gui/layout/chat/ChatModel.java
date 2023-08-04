package gui.layout.chat;

import gui.mvc.Model;
import module.dto.ChatRoomDTO;
import module.dto.UserDTO;
import module.retrofit.RetrofitUtils;
import module.service.ChatService;
import module.session.Session;

import java.util.List;

public class ChatModel implements Model {

    public List<ChatRoomDTO> getChatRoomListAll() {
        ChatService service = RetrofitUtils.createService(ChatService.class);

        UserDTO userDTO = (UserDTO) Session.getInstance().getAttribute("userDTO");

        List<ChatRoomDTO> list = RetrofitUtils.getCallBody(service.getUserRoomListAll(userDTO.getNo()));

        return list;
    }

}
