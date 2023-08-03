package module.socket;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class ChatWebSocket {

    private static ChatWebSocket instance;

    private OkHttpClient client;
    private Request request;
    private WebSocket webSocket;

    public static ChatWebSocket getInstance() {
        if(instance == null) {
            instance = new ChatWebSocket();
        }

        return instance;
    }

    public void startUP() {

    }

    public void shutDown() {

    }

    public static OkHttpClient createOkHttpClient() {
        OkHttpClient client = new OkHttpClient.Builder()
//                .connectTimeout(20, TimeUnit.SECONDS)
//                .writeTimeout(60, TimeUnit.SECONDS)
//                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Request request = new Request.Builder()
                .url("127.0.0.1:8080")
                .build();

        WebSocket socket = client.newWebSocket(request, ;

        return client;
    }
}
