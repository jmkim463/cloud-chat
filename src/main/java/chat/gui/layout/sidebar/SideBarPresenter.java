package chat.gui.layout.sidebar;

import chat.gui.components.Frame;
import chat.gui.layout.MainFrame;
import chat.gui.layout.chat.ChatApp;
import chat.gui.layout.friend.FriendApp;
import chat.gui.layout.login.LoginApp;
import chat.gui.layout.popup.friend.FriendView;

import java.awt.*;

public class SideBarPresenter {

    private final SideBarView view;
    private final SideBarModel model;

    public SideBarPresenter(SideBarModel model, SideBarView view) {
        this.model = model;
        this.view = view;

        init();
    }

    private void init() {

    }

    public void openFriendLayout() {
        FriendApp app = new FriendApp();
        app.open();
    }

    public void openChatLayout() {
        ChatApp app = new ChatApp();
        app.open();
    }

    public void logout() {
        MainFrame.getInstance().dispose();

        LoginApp app = new LoginApp();
        app.open();
    }


}
