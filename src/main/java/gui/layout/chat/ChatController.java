package gui.layout.chat;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import gui.components.EventObserver;
import gui.layout.chat.view.ChatView;
import gui.mvc.Controller;
import gui.mvc.Model;
import gui.mvc.View;
import module.Storage;
import module.dto.ChatRoomDTO;
import module.SocketManager;
import module.dto.UserDTO;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ChatController implements Controller {

    private ChatView view = new ChatView();
    private ChatModel model = new ChatModel();

    private SocketManager socketManager = SocketManager.getInstance();

    public ChatController() {
        init();
    }

    private void init() {
        List<ChatRoomDTO> roomDTOList = model.getChatRoomListAll();

        view.setChatRoomList(roomDTOList);
        view.setSendMessageListener(new ClickSendMessage());

        socketManager.startUp(new WebSocketListener() {

            @Override
            public void onOpen(@NotNull WebSocket webSocket, @NotNull Response response) {
                socketManager.sendMessage("ENTER");
            }

            @Override
            public void onMessage(@NotNull WebSocket webSocket, @NotNull String text) {
                view.receiveMessage(text);
            }
        });
    }

    class ClickSendMessage extends EventObserver {
        @Override
        public void execute(Map<String, Object> paramMap) {
            socketManager.sendMessage("MESSAGE", paramMap);
        }
    }

    @Override
    public Model getModel() {
        return model;
    }

    @Override
    public View getView() {
        return view;
    }

}
