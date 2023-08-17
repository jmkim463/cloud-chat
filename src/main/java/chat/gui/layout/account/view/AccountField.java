package chat.gui.layout.account.view;

import chat.gui.components.ComboBox;
import chat.gui.components.LabelBuilder;
import chat.gui.components.Panel;
import chat.gui.components.button.Button;
import chat.gui.components.button.ButtonStyle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AccountField extends chat.gui.components.Panel {

    private final JTextField id;
    private final JTextField password;
    private final JTextField passwordCheck;
    private final JTextField name;

    private final chat.gui.components.button.Button sameIDCheckButton;

    private boolean isCheckHaveSameID = false;

    public AccountField() {
        id = new JTextField();
        password = new JPasswordField();
        passwordCheck = new JPasswordField();
        name = new JTextField();

        sameIDCheckButton = new chat.gui.components.button.Button(80,25,"중복확인").setFont(12);

        init();
    }

    private void init() {
        sameIDCheckButton.setCheckEmptyTextComponent(id);

        id.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                isCheckHaveSameID = false;
            }
        });

        chat.gui.components.Panel p = new chat.gui.components.Panel(new BorderLayout(0, 15));
        p.add(id);
        p.add(sameIDCheckButton, BorderLayout.EAST);

        JTextField email = new JTextField();
        ComboBox<String> domain = new ComboBox<>();
        domain.addItem("gmail.com");
        domain.addItem("naver.com");

        email.setPreferredSize(new Dimension(150, 25));
        domain.setPreferredSize(new Dimension(100, 25));

        chat.gui.components.Panel grid = new chat.gui.components.Panel(new GridLayout(0, 1, 0, 5));
        grid.add(getEmpty(280, 28));
        grid.add(new LabelBuilder("아이디").setFont(13).getLabel());
        grid.add(p);
        grid.add(new LabelBuilder("비밀번호").setFont(13).getLabel());
        grid.add(password);
        grid.add(new LabelBuilder("비밀번호 확인").setFont(13).getLabel());
        grid.add(passwordCheck);
        grid.add(new LabelBuilder("이름").setFont(13).getLabel());
        grid.add(name);
        grid.add(new LabelBuilder("이메일").setFont(13).getLabel());
        grid.add(cover(email, new LabelBuilder("@").setFont(13).getLabel(), domain));

        chat.gui.components.button.Button loginButton = new chat.gui.components.button.Button(135, 35, "완료").setFont(13).setStyle(ButtonStyle.Success);
        loginButton.setCheckEmptyTextComponent(id, password, passwordCheck, name);

        chat.gui.components.button.Button cancelButton = new chat.gui.components.button.Button(135, 35,"취소").setFont(13).setStyle(ButtonStyle.Danger);

        chat.gui.components.Panel panel = new Panel(new BorderLayout(0, 50));
        panel.add(grid);
        panel.add(cover(FlowLayout.CENTER, 10, 5,  loginButton, cancelButton), BorderLayout.SOUTH);
        add(panel);
    }

    public String getID() {
        return id.getText();
    }

    public Button getSameIDCheckButton() {
        return sameIDCheckButton;
    }
}
