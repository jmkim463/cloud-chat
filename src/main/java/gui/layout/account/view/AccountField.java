package gui.layout.account.view;

import gui.components.ComboBox;
import gui.components.Font;
import gui.components.LabelBuilder;
import gui.components.button.Button;
import gui.components.Panel;
import gui.components.button.ButtonStyle;
import okhttp3.MultipartBody;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
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

        Button idChecKButton = new Button(80,25,"중복확인").setFont(12);
        idChecKButton.setCheckEmptyTextComponent(id);

        Panel p = new Panel(new BorderLayout(0, 15));
        p.add(id);
        p.add(idChecKButton, BorderLayout.EAST);

        JTextField email = new JTextField();
        ComboBox<String> domain = new ComboBox<>();
        domain.addItem("gmail.com");
        domain.addItem("naver.com");

        email.setPreferredSize(new Dimension(150, 25));
        domain.setPreferredSize(new Dimension(100, 25));

        Panel grid = new Panel(new GridLayout(0, 1, 0, 5));
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

        Button loginButton = new Button(135, 35, "완료").setFont(13).setStyle(ButtonStyle.Success);
        loginButton.setCheckEmptyTextComponent(id, password, passwordCheck, name);

        Button cancelButton = new Button(135, 35,"취소").setFont(13).setStyle(ButtonStyle.Danger);

        Panel panel = new Panel(new BorderLayout(0, 50));
        panel.add(grid);
        panel.add(cover(FlowLayout.CENTER, 10, 5,  loginButton, cancelButton), BorderLayout.SOUTH);
        add(panel);
    }


}
