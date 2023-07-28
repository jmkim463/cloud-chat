package gui.layout.account;

import gui.components.Frame;
import gui.components.Modal;
import gui.layout.account.view.AccountView;
import gui.mvc.Controller;
import gui.mvc.Model;
import gui.mvc.View;

public class AccountController implements Controller {

    private AccountModel model = new AccountModel();
    private AccountView view = new AccountView();

    public static void main(String[] args) {
        new Frame();

        new AccountController().getView().open();
    }

    public AccountController() {
        init();
    }

    private void init() {

    }

    public void account() {

    }

    public void isHaveSameID() {

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
