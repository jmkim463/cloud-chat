package chat.gui.layout.popup.pending.view;

import chat.gui.components.Panel;
import chat.gui.components.RadioButton;
import chat.gui.components.button.Button;
import chat.module.dto.UserDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UserItem extends Panel {

    private final RadioButton radio;
    private final Button btn;
    private UserDTO userDTO;

    public UserItem(UserDTO userDTO) {
        this.userDTO = userDTO;
        radio = new RadioButton();
        btn = new Button(73, 20, "친추하기");

        init();
    }

    private void init() {
        setLayout(new BorderLayout(30, 0));

        StringBuilder stringBuilder = new StringBuilder(userDTO.getName());
        stringBuilder.replace(1, stringBuilder.length(), "*".repeat(stringBuilder.length() - 1));

        radio.setText(stringBuilder.toString());
        btn.setFont(10);
        btn.setVisible(false);
        btn.setClickEvent(e -> {

        });

        add(cover(radio), BorderLayout.WEST);
        add(cover(btn), BorderLayout.EAST);

        radio.addItemListener(e -> {
            btn.setVisible(radio.isSelected());
        });
    }

    public RadioButton getRadio() {
        return radio;
    }

    public void addClickFriendAddButton(ActionListener actionListener) {
        btn.setClickEvent(actionListener);
    }
}
