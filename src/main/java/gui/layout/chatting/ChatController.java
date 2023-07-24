package gui.layout.chatting;

import gui.layout.MainFrame;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ChatController {

    private MainFrame mainFrame = MainFrame.getInstance();

    public static void main(String[] args) {
        new ChatController().show();

        MainFrame.getInstance().setVisible(true);
    }

    public ChatController() {
        init();
    }

    private void init() {

    }

    public void show() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new ChatRoomList(), BorderLayout.WEST);
        panel.add(new ChatField());

        mainFrame.changeScreenWithSideBar(panel);
    }

}
