package chat.module;

import chat.module.dto.MessageDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import chat.module.dto.UserDTO;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

import java.util.Map;

public class SocketManager {

    private final static String ENTER = "ENTER";
    private final static String MESSAGE = "MESSAGE";

    private static SocketManager instance;
    private final static String BASE_URL = "http://127.0.0.1:8080/ws";

    private final OkHttpClient client;
    private final Request request;
    private WebSocket socket;

    public static SocketManager getInstance() {
        if(instance == null) {
            instance = new SocketManager();
        }

        return instance;
    }

    private SocketManager() {
        client = new OkHttpClient.Builder().build();
        request = new Request.Builder().url(BASE_URL).build();
    }

    public boolean isStarted() {
        return socket != null;
    }

    public void startUp(WebSocketListener listener) {
        socket = client.newWebSocket(request, listener);
    }

    public void shutDown() {
        sendMessage("EXIT");

        socket.close(1000, "close");

        instance = null;
    }

    public void sendMessage(String type) {
        sendMessage(type, null);
    }

    public void sendMessage(String type, MessageDTO messageDTO) {
        JsonObject json = new JsonObject();

        Long no = ((UserDTO) Storage.getInstance().getData(Storage.LOGIN_USER)).getNo();

        json.addProperty("type", type.toUpperCase());
        json.addProperty("senderNo", no);

        if(messageDTO != null) {
            json.addProperty("messageDTO", JsonUtils.toString(messageDTO));
        }

        socket.send(json.toString());
    }
}
