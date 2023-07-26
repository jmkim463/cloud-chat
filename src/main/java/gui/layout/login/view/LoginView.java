package gui.layout.login.view;

import gui.components.Frame;
import gui.components.Logic;
import gui.components.Panel;
import gui.mvc.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends Frame implements View {

    private LoginField field = new LoginField();

    public LoginView() {
        init();
    }

    private void init() {
        Panel panel = new Panel(new BorderLayout());

        panel.add(new LoginSideBar(), BorderLayout.WEST);
        panel.add(field);

        add(panel);
    }

    public void setLoginLogic(Logic logic) {
        field.setLoginLogic(logic);
    }

    public void setAccountLogic(Logic logic) {
        field.setAccountLogic(logic);
    }

    public String getID() {
        return field.getID();
    }

    public String getPassword() {
        return field.getPassword();
    }

    @Override
    public void open() {
        setVisible(true);
    }

    @Override
    public void close() {
        dispose();
    }
}
