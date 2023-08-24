package chat.gui.layout.popup.friend;

import chat.gui.components.Modal;
import chat.gui.layout.App;

public class FriendApp implements App {

    private final FriendModel model;
    private final FriendView view;
    private final FriendPresenter presenter;

    public FriendApp() {
        model = new FriendModel();
        view = new FriendView();
        presenter = new FriendPresenter(model, view);
    }

    @Override
    public void open() {

    }

    @Override
    public void close() {

    }
}
