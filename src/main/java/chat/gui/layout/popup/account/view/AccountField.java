package chat.gui.layout.popup.account.view;

import chat.gui.components.ComboBox;
import chat.gui.components.LabelBuilder;
import chat.gui.components.Panel;
import chat.gui.components.button.Button;
import chat.gui.components.button.ButtonStyle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AccountField extends Panel {

    private final JTextField id;
    private final JTextField password;
    private final JTextField passwordCheck;
    private final JTextField username;
    private final JTextField email;
    private final ComboBox<String> domain;

    private final Button sameIDCheckButton;
    private final Button cancelButton;
    private final Button accountButton;

    public AccountField() {
        id = new JTextField();
        password = new JPasswordField();
        passwordCheck = new JPasswordField();
        username = new JTextField();
        email = new JTextField();
        domain = new ComboBox<>();

        accountButton = new Button(135, 35, "완료").setFont(13).setStyle(ButtonStyle.Success);
        sameIDCheckButton = new Button(80,25,"중복확인").setFont(12);
        cancelButton = new Button(135, 35,"취소").setFont(13).setStyle(ButtonStyle.Danger);
        init();
    }

    private void init() {
        sameIDCheckButton.setCheckEmptyTextComponent(id);
        accountButton.setCheckEmptyTextComponent(id, password, passwordCheck, username, email);

        Panel p = new Panel(new BorderLayout(0, 15));
        p.add(id);
        p.add(sameIDCheckButton, BorderLayout.EAST);

        domain.addItem("gmail.com");
        domain.addItem("naver.com");

        email.setPreferredSize(new Dimension(190, 25));
        domain.setPreferredSize(new Dimension(100, 25));

        Panel emailPanel = new Panel(new FlowLayout(1, 0, 5));
        emailPanel.add(email);
        emailPanel.add(new LabelBuilder("@").setFont(13).getLabel());
        emailPanel.add(domain);

        Panel grid = new Panel(new GridLayout(0, 1, 0, 5));
        grid.add(getEmpty(280, 28));
        grid.add(new LabelBuilder("아이디").setFont(13).getLabel());
        grid.add(p);
        grid.add(new LabelBuilder("비밀번호").setFont(13).getLabel());
        grid.add(password);
        grid.add(new LabelBuilder("비밀번호 확인").setFont(13).getLabel());
        grid.add(passwordCheck);
        grid.add(new LabelBuilder("이름").setFont(13).getLabel());
        grid.add(username);
        grid.add(new LabelBuilder("이메일").setFont(13).getLabel());
        grid.add(emailPanel);

        Panel panel = new Panel(new BorderLayout(0, 50));
        panel.add(grid);
        panel.add(cover(FlowLayout.CENTER, 10, 5,  accountButton, cancelButton), BorderLayout.SOUTH);
        add(panel);
    }

    public Button getCancelButton() {
        return cancelButton;
    }

    public JTextField getID() {
        return id;
    }

    public JTextField getPassword() {
        return password;
    }

    public JTextField getPasswordCheck() {
        return passwordCheck;
    }

    public JTextField getUsername() {
        return username;
    }

    public JTextField getEmail() {
        return email;
    }

    public ComboBox<String> getDomain() {
        return domain;
    }

    public Button getSameIDCheckButton() {
        return sameIDCheckButton;
    }

    public Button getAccountButton() {
        return accountButton;
    }
}
