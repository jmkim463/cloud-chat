package gui.layout.login.view;

import gui.components.*;
import gui.components.button.Button;
import gui.components.Panel;
import gui.layout.account.AccountController;
import gui.mvc.Controller;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LoginField extends Panel {

    private JTextField id = new JTextField();
    private JTextField password = new JPasswordField();

    private EventObserver observer;

    public LoginField() {
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

        Button btn = new Button(200, 35, "Log in");
        btn.setCheckEmptyTextComponent(new JTextComponent[]{id, password});
        btn.setClickEvent(e -> {
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("id", id.getText());
            paramMap.put("password", password.getText());

            observer.execute(paramMap);
        });

        JLabel signup = new LabelBuilder("Sign Up")
                .setColor(new Color(71, 126, 251))
                .setClickListener(e -> {
                    Controller controller = new AccountController();
                    controller.getView().open();
                }).getLabel();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(cover(new LabelBuilder("CLOUD CHAT").setFont("Edu SA Beginner", 1, 50).getLabel()));
        panel.add(getEmpty(50));
        panel.add(cover(new LabelBuilder("Welcome to Cloud Chat").setFont(20).setColor(Color.gray).getLabel()));
        panel.add(getEmpty(50));
        panel.add(cover(grid));
        panel.add(cover(btn));
        panel.add(getEmpty(80));
        panel.add(cover(new LabelBuilder("Don't have an account yet?").setFont(13).setColor(Color.gray).getLabel(), signup));

        add(panel);
    }

    void setObserver(EventObserver observer) {
        this.observer = observer;
    }
}
