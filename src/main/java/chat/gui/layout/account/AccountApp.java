package chat.gui.layout.account;

import chat.gui.components.Modal;
import chat.gui.layout.App;

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
        modal = new Modal(380, 700);

        init();
    }

    private void init() {
        view.addSameIDCheckClickListener(e -> presenter.clickIsHaveSameIDButton());
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
        modal.dispose();
    }
}
