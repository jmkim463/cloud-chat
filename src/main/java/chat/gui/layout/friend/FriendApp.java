package chat.gui.layout.friend;

import chat.gui.components.Frame;
import chat.gui.layout.App;
import chat.gui.layout.MainFrame;
import chat.gui.layout.sidebar.SideBar;
import chat.module.Storage;
import chat.module.dto.UserDTO;

import java.awt.*;

public class FriendApp implements App {

    public static void main(String[] args) {
        UserDTO user = UserDTO.builder()
                .no(1L)
                .build();

        Storage.getInstance().setData(Storage.LOGIN_USER, user);

        new FriendApp().open();
    }

    private final FriendModel model;
    private final FriendView view;
    private final FriendPresenter presenter;

    public FriendApp() {
        this.model = new FriendModel();
        this.view = new FriendView();
        this.presenter = new FriendPresenter(model, view);

        init();
    }

    private void init() {
        presenter.refresh();
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
