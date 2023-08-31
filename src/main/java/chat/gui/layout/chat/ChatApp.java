package chat.gui.layout.chat;

import chat.gui.layout.App;
import chat.gui.layout.MainFrame;
import chat.gui.layout.sidebar.SideBar;
import chat.gui.layout.sidebar.SideBarView;
import chat.gui.components.Frame;
import chat.module.SocketManager;
import chat.module.dto.ChatRoomDTO;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class ChatApp implements App {

    private final ChatModel model;
    private final ChatView view;
    private final ChatPresenter presenter;

    public ChatApp() {
        model = new ChatModel();
        view = new ChatView();
        presenter = new ChatPresenter(model, view);

        init();
    }

    private void init() {
        view.addSendMessageListener(e -> presenter.clickMessageSendButton());
        view.addClickImageLabelListener(e -> presenter.clickImageLabel());

        presenter.refreshChatRoomList();

        SocketManager manager = SocketManager.getInstance();
        manager.startUp(new WebSocketListener() {
            @Override
            public void onOpen(@NotNull WebSocket webSocket, @NotNull Response response) {
                manager.sendMessage("ENTER");
            }

            @Override
            public void onMessage(@NotNull WebSocket webSocket, @NotNull String text) {
                presenter.receiveMessage(text);
            }
        });
    }

    public void selectChatroom(ChatRoomDTO chatRoomDTO) {
        presenter.selectChatRoom(chatRoomDTO);
    }

    @Override
    public void open() {
        Frame frame = MainFrame.getInstance();

        Panel panel = new Panel(new BorderLayout());
        panel.add(new SideBar().getView(), BorderLayout.WEST);
        panel.add(view);

        Container container = frame.getContentPane();
        container.removeAll();
        container.add(panel);

        frame.setVisible(true);
    }

    @Override
    public void close() {

    }
}
