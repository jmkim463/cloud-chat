package chat.gui.layout.login;

import chat.gui.components.Panel;
import chat.gui.layout.login.view.LoginField;
import chat.gui.layout.login.view.LoginSideBar;

import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends Panel {

    private final LoginField field;
    private final LoginSideBar bar;

    public LoginView() {
        field = new LoginField();
        bar = new LoginSideBar();

        init();
    }

    private void init() {
        setLayout(new BorderLayout());

        add(bar, BorderLayout.WEST);
        add(field);
    }

    public void addLoginClickListener(ActionListener actionListener) {
        field.getLoginButton().setClickEvent(actionListener);
    }

    public String getID() {
        return field.getID();
    }

    public String getPassword() {
        return field.getPassword();
    }

}
