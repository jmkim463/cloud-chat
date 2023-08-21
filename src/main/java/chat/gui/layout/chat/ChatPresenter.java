package chat.gui.layout.chat;

import chat.module.Storage;
import chat.module.dto.UserDTO;
import com.google.gson.Gson;
import chat.module.SocketManager;
import chat.module.dto.MessageDTO;

import java.awt.*;
import java.util.HashMap;

public class ChatPresenter {

    private final ChatView view;
    private final ChatModel model;

    private final Gson gson;

    public ChatPresenter(ChatModel model, ChatView view) {
        this.model = model;
        this.view = view;

        gson = new Gson();

        init();
    }

    private void init() {

    }

    public void clickMessageSendButton() {
        String content = view.getMessage();

        UserDTO userDTO = (UserDTO) Storage.getInstance().getData(Storage.LOGIN_USER);

        MessageDTO messageDTO = MessageDTO.builder()
                .senderDTO(userDTO)
                .content(content).build();

        SocketManager manager = SocketManager.getInstance();
        manager.sendMessage("MESSAGE", messageDTO);

        view.addMessage(messageDTO);
    }

    public void receiveMessage(String text) {
        MessageDTO messageDTO = gson.fromJson(text, MessageDTO.class);

        view.addMessage(messageDTO);
    }
}
