package gui.layout.login.view;

import gui.components.EventObserver;
import gui.components.Frame;
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

    public void setClickLoginListener(EventObserver observer) {
        field.setObserver(observer);
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
