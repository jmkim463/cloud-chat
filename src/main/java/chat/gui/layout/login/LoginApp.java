package chat.gui.layout.login;

import chat.gui.components.Frame;
import chat.gui.layout.App;
import chat.gui.layout.MainFrame;

import java.awt.*;

public class LoginApp implements App {

    private final LoginModel model;
    private final LoginView view;
    private final LoginPresenter presenter;

    public LoginApp() {
        model = new LoginModel();
        view = new LoginView();
        presenter = new LoginPresenter(model, view);

        init();
    }

    private void init() {
        view.addLoginClickListener(e -> presenter.clickLoginButton());
    }

    @Override
    public void open() {
        Frame frame = MainFrame.getInstance();

        Container container = frame.getContentPane();
        container.removeAll();
        container.add(view);

        frame.setVisible(true);
    }

    @Override
    public void close() {
        Frame frame = MainFrame.getInstance();

        frame.dispose();
    }
}
