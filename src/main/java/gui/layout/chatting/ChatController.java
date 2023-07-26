package gui.layout.chatting;

import gui.components.Panel;
import gui.layout.MainFrame;
import gui.layout.chatting.view.ChatField;
import gui.layout.chatting.view.ChatRoomList;
import gui.layout.chatting.view.ChatView;
import gui.mvc.Controller;
import gui.mvc.Model;
import gui.mvc.View;

import java.awt.*;

public class ChatController implements Controller {

    private ChatView view = new ChatView();
    private ChatModel model = new ChatModel();

    public ChatController() {
        init();
    }

    private void init() {

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
