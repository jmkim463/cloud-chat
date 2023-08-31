package chat.gui.layout.chat;

import chat.module.RetrofitUtils;
import chat.module.Storage;
import chat.module.dto.ChatRoomDTO;
import chat.module.dto.MessageDTO;
import chat.module.dto.UserDTO;
import chat.module.service.ChatService;
import chat.module.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.MultipartBody;
import retrofit2.Call;

import java.io.File;
import java.util.List;

public class ChatModel {

    private final ChatService service;

    private final JsonParser parser;

    public ChatModel() {
        service = RetrofitUtils.createService(ChatService.class);
        parser = new JsonParser();
    }

    public List<ChatRoomDTO> getUserChatRoomList() {
        UserDTO user = (UserDTO) Storage.getInstance().getData(Storage.LOGIN_USER);

        List<ChatRoomDTO> list = RetrofitUtils.getCallBody(service.selectUserChatRoomList(user.getNo()));

        return list;
    }

    public List<MessageDTO> getChatRoomOfMessageList(Long chatroomNo) {
        // TODO SQL LIGHT 적용예정
        List<MessageDTO> list = RetrofitUtils.getCallBody(service.selectChatRoomOfMessage(chatroomNo));

        return list;
    }

    public String uploadImage(File file) {
        MultipartBody.Part part = RetrofitUtils.imageToMultipartBody(file);

        JsonElement element = parser.parse(RetrofitUtils.getCallBody(service.uploadImage(part)));
        JsonObject json = element.getAsJsonObject();

        return json.get("url").getAsString();
    }

}
