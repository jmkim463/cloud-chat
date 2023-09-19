package chat.gui.layout.popup.group;

import chat.gui.components.Modal;
import chat.gui.layout.App;
import chat.module.Storage;
import chat.module.dto.UserDTO;

import java.awt.*;

public class GroupApp implements App {

    private final GroupModel model;
    private final GroupView view;
    private final GroupPresenter presenter;

    private final Modal modal;

    public static void main(String[] args) {
        Storage.getInstance().setData(Storage.LOGIN_USER, UserDTO.builder().no(1L).build());

        GroupApp app = new GroupApp();

        app.open();
    }

    public GroupApp() {
        model = new GroupModel();
        view = new GroupView();
        modal = new Modal(500, 450);
        presenter = new GroupPresenter(model, view, modal);

        init();
    }

    private void init() {
        view.getButton().setClickEvent(e -> presenter.clickSaveButtonListener());
    }

    @Override
    public void open() {
        Container container = modal.getContentPane();
        container.removeAll();
        container.add(view);

        modal.setVisible(true);
    }

    @Override
    public void close() {

    }
}
