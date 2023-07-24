package gui.layout.login;

import gui.components.Frame;
import gui.layout.MainFrame;
import gui.layout.chatting.ChatController;
import gui.layout.chatting.ChatField;
import gui.layout.chatting.ChatRoomList;

import javax.swing.*;

public class LoginController {

    private Frame frame = new Frame();

    public static void main(String[] args) {
        new LoginController().show();

    }

    public LoginController() {
        init();
    }

    private void init() {
        frame.add(new LoginField());
    }

    public void show() {
        frame.setVisible(true);
    }

}
