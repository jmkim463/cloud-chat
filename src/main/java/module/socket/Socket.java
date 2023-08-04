package module.socket;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class Socket {

    private final static Socket instance = new Socket();
    private final static String BASE_URL = "http://127.0.0.1:8080/ws";

    private OkHttpClient client;
    private Request request;
    private WebSocket socket;

    public static Socket getInstance() {
        return instance;
    }

    private Socket() {
        client = new OkHttpClient.Builder().build();
        request = new Request.Builder().url(BASE_URL).build();
    }

    public void startUp(WebSocketListener listener) {
        client = new OkHttpClient().newBuilder().build();

        request = new Request.Builder()
                .url(BASE_URL)
                .build();

        socket = client.newWebSocket(request, listener);
    }

    public void shutDown() {
        socket.close(1000, "close");
    }

    public void sendMessage(String text) {
        socket.send(text);
    }

}
