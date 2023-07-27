package gui.layout.account.view;

import gui.components.LabelBuilder;
import gui.components.button.Button;
import gui.components.Panel;
import gui.components.button.ButtonStyle;

import javax.swing.*;
import java.awt.*;

public class AccountField extends Panel {

    private JTextField id = new JTextField();
    private JTextField password = new JPasswordField();
    private JTextField passwordCheck = new JPasswordField();
    private JTextField name = new JTextField();

    public AccountField() {
        init();
    }

    private void init() {

        Button idChecKButton = new Button(80,30,"중복확인").setFont(12);
        idChecKButton.setCheckEmptyTextComponent(id);

        Panel p = new Panel(new BorderLayout(0, 15));
        p.add(id);
        p.add(idChecKButton, BorderLayout.EAST);

        Panel grid = new Panel(new GridLayout(0, 1, 0, 5));
        grid.add(getEmpty(280, 30));
        grid.add(new LabelBuilder("아이디").setFont(13).getLabel());
        grid.add(p);
        grid.add(new LabelBuilder("비밀번호").setFont(13).getLabel());
        grid.add(password);
        grid.add(new LabelBuilder("비밀번호 확인").setFont(13).getLabel());
        grid.add(passwordCheck);
        grid.add(new LabelBuilder("이름").setFont(13).getLabel());
        grid.add(name);

        Button loginButton = new Button(135, 35, "취소").setFont(13);
        loginButton.setCheckEmptyTextComponent(id, password, passwordCheck, name);

        Button cancelButton = new Button(135, 35,"취소").setFont(13).setStyle(ButtonStyle.Danger);

        Panel panel = new Panel(new BorderLayout(0, 50));
        panel.add(grid);
        panel.add(cover(loginButton, cancelButton), BorderLayout.SOUTH);
        add(panel);
    }


}
