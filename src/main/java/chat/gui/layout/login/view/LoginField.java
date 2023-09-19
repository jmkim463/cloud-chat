package chat.gui.layout.login.view;

import chat.gui.components.LabelBuilder;
import chat.gui.components.Panel;
import chat.gui.components.button.Button;
import chat.gui.layout.popup.account.AccountApp;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;

public class LoginField extends Panel {

    private final JTextField id;
    private final JTextField password;

    private final Button loginButton;

    public LoginField() {
        id = new JTextField();
        password = new JPasswordField();
        loginButton = new Button(180, 35, "Log in");

        init();
    }

    private void init() {
        setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        id.setPreferredSize(new Dimension(300, 28));
        password.setPreferredSize(new Dimension(300, 28));
        password.setBorder(id.getBorder());

        Panel grid = new Panel(new GridLayout(0, 1));
        grid.add(new LabelBuilder("User ID").setFont(13).setColor(Color.lightGray).getLabel());
        grid.add(id);
        grid.add(new JPanel());
        grid.add(new LabelBuilder("Password").setFont(13).setColor(Color.lightGray).getLabel());
        grid.add(password);
        grid.add(new JPanel());

        loginButton.setCheckEmptyTextComponent(new JTextComponent[]{id, password});

        JLabel signup = new LabelBuilder("Sign Up")
                .setColor(new Color(71, 126, 251))
                .setClickListener(e -> {
                    AccountApp app = new AccountApp();
                    app.open();
                }).getLabel();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(cover(new LabelBuilder("CLOUD CHAT").setFont("Edu SA Beginner", 1, 50).getLabel()));
        panel.add(getEmpty(50));
        panel.add(cover(new LabelBuilder("Welcome to Cloud Chat").setFont(20).setColor(Color.gray).getLabel()));
        panel.add(getEmpty(50));
        panel.add(cover(grid));
        panel.add(cover(loginButton));
        panel.add(getEmpty(80));
        panel.add(cover(new LabelBuilder("Don't have an account yet?").setFont(13).setColor(Color.gray).getLabel(), signup));

        add(panel);
    }

    public String getID() {
        return id.getText();
    }

    public String getPassword() {
        return password.getText();
    }

    public Button getLoginButton() {
        return loginButton;
    }
}
