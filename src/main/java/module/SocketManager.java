package module;

import com.google.gson.JsonObject;
import module.dto.UserDTO;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

import java.util.Map;

public class SocketManager {

    private static SocketManager instance;
    private final static String BASE_URL = "http://127.0.0.1:8080/ws";

    private OkHttpClient client;
    private Request request;
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

    public void sendMessage(String type, Map<String, Object> paramMap) {
        JsonObject json = new JsonObject();

        Storage storage = Storage.getInstance();
        UserDTO userDTO = (UserDTO) storage.getAttribute("userDTO");

        String userNo = userDTO.getNo();

        json.addProperty("userNo", userNo);
        json.addProperty("type", type.toUpperCase());

        if(paramMap != null) {
            for(String key : paramMap.keySet()) {
                json.addProperty(key, paramMap.get(key).toString());
            }
        }

        socket.send(json.toString());
    }
}
