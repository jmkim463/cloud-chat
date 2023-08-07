package gui.layout.chat;

import gui.mvc.Model;
import module.dto.ChatRoomDTO;
import module.dto.UserDTO;
import module.RetrofitUtils;
import module.service.ChatService;
import module.Storage;

import java.util.List;

public class ChatModel implements Model {

    public List<ChatRoomDTO> getChatRoomListAll() {
        ChatService service = RetrofitUtils.createService(ChatService.class);

        UserDTO userDTO = (UserDTO) Storage.getInstance().getAttribute("userDTO");

        List<ChatRoomDTO> list = RetrofitUtils.getCallBody(service.getUserRoomListAll(userDTO.getNo()));

        return list;
    }

}
