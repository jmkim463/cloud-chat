package gui.layout.chatting.view;

import gui.components.Panel;
import gui.mvc.Controller;
import gui.mvc.View;
import gui.layout.MainFrame;
import gui.layout.login.LoginController;
import module.dto.ChatRoomDTO;

import java.awt.*;
import java.util.List;

public class ChatView implements View {

    private MainFrame frame = MainFrame.getInstance();

    public ChatView() {
        init();
    }

    private ChatRoomList chatRoomList = new ChatRoomList();

    private void init() {
        Panel panel = new Panel(new BorderLayout());
        panel.add(chatRoomList, BorderLayout.WEST);
        panel.add(new ChatField());

        frame.changeScreenWithSideBar(panel);
    }

    public void setAllChatRoomList(List<ChatRoomDTO> list) {
        chatRoomList.setChatRoomList(list);
    }

    @Override
    public void open() {
        frame.setVisible(true);
    }

    @Override
    public void close() {
        frame.dispose();

        //TODO 로그아웃 로직 추가

        Controller controller = new LoginController();
        controller.getView().open();
    }
}
