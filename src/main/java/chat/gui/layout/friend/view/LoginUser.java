package chat.gui.layout.friend.view;

import chat.gui.components.ImageBuilder;
import chat.gui.components.Panel;
import chat.gui.components.LabelBuilder;
import chat.gui.components.button.Button;
import chat.gui.components.button.ButtonStyle;
import chat.gui.layout.popup.account.AccountApp;
import chat.module.Storage;
import chat.module.dto.UserDTO;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class LoginUser extends Panel {

    public LoginUser() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 10, 0, 10));

        UserDTO user = (UserDTO) Storage.getInstance().getData(Storage.LOGIN_USER);

        JLabel image = new JLabel(new ImageBuilder(user.getImageURL(), ImageBuilder.URL).changeCircleImage(80).getImageIcon());
        JLabel name = new LabelBuilder(user.getName()).setFont(20).getLabel();
        JLabel id = new LabelBuilder(user.getId()).setFont(14).getLabel();
        JLabel email = new LabelBuilder(user.getEmail()).setFont(14).getLabel();

        Panel info = new Panel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        info.add(name);
        info.add(id);
        info.add(email);

        Button button = new Button(100, 25, "정보 수정");
        button.setStyle(ButtonStyle.Secondary);
        button.setFont(13);
        button.setClickEvent(e -> {
            AccountApp app = new AccountApp();
            app.setAccount((UserDTO) Storage.getInstance().getData(Storage.LOGIN_USER));
            app.open();
        });

        add(cover(image, info), BorderLayout.WEST);
        add(button, BorderLayout.EAST);
    }

}
