package gui.layout.chat;

import gui.components.EventObserver;
import gui.layout.chat.view.ChatView;
import gui.mvc.Controller;
import gui.mvc.Model;
import gui.mvc.View;
import module.dto.ChatRoomDTO;
import module.socket.Socket;
import module.socket.SocketListener;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.List;
import java.util.Map;

public class ChatController implements Controller {

    private ChatView view = new ChatView();
    private ChatModel model = new ChatModel();

    private Socket socket = Socket.getInstance();

    public ChatController() {
        init();
    }

    private void init() {
        List<ChatRoomDTO> roomDTOList = model.getChatRoomListAll();

        view.setChatRoomList(roomDTOList);
        view.setSendMessageListener(new ClickSendMessage());

        socket.startUp(new SocketListener() {
            @Override
            public void onMessage(@NotNull WebSocket webSocket, @NotNull String text) {
                view.receiveMessage(text);
            }


        });
    }

    @Override
    public Model getModel() {
        return model;
    }

    @Override
    public View getView() {
        return view;
    }

    class ClickSendMessage extends EventObserver {
        @Override
        public void execute(Map<String, Object> paramMap) {
            String message = (String) paramMap.get("message");

            socket.sendMessage(message);
        }
    }
}
