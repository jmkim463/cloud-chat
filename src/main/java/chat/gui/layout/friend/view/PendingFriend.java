package chat.gui.layout.friend.view;

import chat.gui.components.ImageBuilder;
import chat.gui.components.LabelBuilder;
import chat.gui.components.Panel;
import chat.gui.components.button.Button;
import chat.module.dto.UserDTO;

import javax.swing.*;
import java.awt.*;

public class PendingFriend extends Panel {

    private final UserDTO userDTO;

    private final JLabel cancel;
    private final Button button;

    public PendingFriend(UserDTO userDTO) {
        this.userDTO = userDTO;

        button = new Button(60, 25, 15, "추가");
        cancel = new JLabel(new ImageBuilder("cancel", ImageBuilder.ICON)
                .setSize(15, 15)
                .changeImageColor(Color.lightGray)
                .getImageIcon());

        init();
    }

    private void init() {
        setLayout(new BorderLayout());

        JLabel image = new JLabel(new ImageBuilder(userDTO.getImageURL(), ImageBuilder.URL).changeCircleImage(50).getImageIcon());

        Panel info = new Panel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        info.add(new LabelBuilder(userDTO.getName()).getLabel());

        button.setFont(12);

        add(cover(image, info), BorderLayout.WEST);
        add(cover(button, cancel), BorderLayout.EAST);
    }

    public JLabel getCancel() {
        return cancel;
    }

    public Button getButton() {
        return button;
    }
}

