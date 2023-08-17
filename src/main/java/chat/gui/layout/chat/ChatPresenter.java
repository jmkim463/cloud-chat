package chat.gui.layout.chat;

import chat.module.Storage;
import chat.module.dto.UserDTO;
import com.google.gson.Gson;
import chat.module.SocketManager;
import chat.module.dto.MessageDTO;

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
        String message = view.getMessage();

        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("message", message);

        SocketManager manager = SocketManager.getInstance();
        manager.sendMessage("MESSAGE", paramMap);

        MessageDTO messageDTO = MessageDTO.builder()
                .senderUserDTO((UserDTO) Storage.getInstance().getData(Storage.LOGIN_USER))
                .content(message)
                .build();

        view.addMessage(messageDTO);
    }

    public void receiveMessage(String text) {
        MessageDTO messageDTO = gson.fromJson(text, MessageDTO.class);

        view.addMessage(messageDTO);
    }
}
