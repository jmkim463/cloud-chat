package gui.layout.login;

import gui.alert.Alert;
import gui.alert.AlertType;
import gui.components.Frame;
import gui.layout.MainFrame;
import gui.layout.chatting.ChatController;
import gui.layout.chatting.ChatField;
import gui.layout.chatting.ChatRoomList;

import javax.swing.*;

public class LoginController {

    private Frame frame = new Frame();
    private LoginField field = new LoginField();

    public static void main(String[] args) {
        new LoginController().show();
    }

    public LoginController() {
        init();
    }

    private void init() {
        field.setClickListener(e -> login());
        frame.add(field);
    }

    public void show() {
        frame.setVisible(true);
    }

    public void login() {
        String id = field.getID();
        String pw = field.getPassword();


        Alert.createAlert(AlertType.SUCCESS, "test", "Test");
    }
}
