package gui.layout.login.view;

import gui.components.*;
import gui.components.Button;
import gui.components.Font;
import gui.components.Panel;
import lombok.extern.java.Log;
import utils.Colors;
import utils.ImageUtils;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginField extends Panel {

    private JTextField id = new JTextField();
    private JTextField password = new JPasswordField();

    private Logic login;
    private Logic account;

    public LoginField() {
        init();
    }

    private void init() {
        setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        id.setPreferredSize(new Dimension(300, 28));
        id.setFont(new Font());
        id.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Colors.getBorderLineColor()));
        password.setPreferredSize(new Dimension(300, 28));
        password.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Colors.getBorderLineColor()));

        Panel grid = new Panel(new GridLayout(0, 1));
        grid.add(new LabelBuilder("User ID").setFont(13).setColor(Color.lightGray).getLabel());
        grid.add(id);
        grid.add(new JPanel());
        grid.add(new LabelBuilder("Password").setFont(13).setColor(Color.lightGray).getLabel());
        grid.add(password);
        grid.add(new JPanel());

        Button btn = new Button(200, 35, "Log in");
        btn.setCheckEmptyTextComponent(new JTextComponent[]{id, password});
        btn.setActionListener(e -> {
            if(login != null) {
                login.action();
            }
        });

        JLabel signup = new LabelBuilder("Sign Up")
                .setColor(new Color(71, 126, 251))
                .setClickListener(this::clickAccountLabel)
                .getLabel();

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

    private void clickAccountLabel() {
        if(account != null) {
            account.action();
        }
    }

    public String getID() {
        return id.getText();
    }

    public String getPassword() {
        return password.getText();
    }

    public void setLoginLogic(Logic logic) {
        this.login = logic;
    }

    public void setAccountLogic(Logic logic) {
        this.account = logic;
    }
}
