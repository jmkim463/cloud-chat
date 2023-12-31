package chat.gui.layout.popup.account;

import chat.gui.components.Modal;
import chat.gui.layout.App;
import chat.module.dto.UserDTO;

import java.awt.*;

public class AccountApp implements App {

    private final AccountModel model;
    private final AccountView view;
    private final AccountPresenter presenter;

    private final Modal modal;

    public AccountApp() {
        model = new AccountModel();
        view = new AccountView();
        presenter = new AccountPresenter(model, view);
        modal = new Modal(380, 690);

        init();
    }

    private void init() {
        view.addSameIDCheckButtonClickListener(e -> presenter.clickSameUsernameCheckButton());
        view.addCancelButtonClickListener(e -> close());
        view.addAccountButtonClickListener(e -> presenter.clickAccountButton());

        presenter.setModal(modal);
    }

    public void setAccount(UserDTO userDTO) {
        presenter.setAccount(userDTO);
    }

    @Override
    public void open() {
        Container container = modal.getContentPane();
        container.removeAll();

        container.add(view.cover());
        modal.setVisible(true);
    }

    @Override
    public void close() {
        modal.dispose();
    }
}
