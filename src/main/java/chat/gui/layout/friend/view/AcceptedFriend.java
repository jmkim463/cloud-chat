package chat.gui.layout.friend.view;

import chat.gui.components.ImageBuilder;
import chat.gui.components.LabelBuilder;
import chat.gui.components.Panel;
import chat.module.dto.UserDTO;

import javax.swing.*;
import java.awt.*;

public class AcceptedFriend extends Panel {

    private final UserDTO userDTO;

    public AcceptedFriend(UserDTO userDTO) {
        this.userDTO = userDTO;

        init();
    }

    private void init() {
        setLayout(new BorderLayout());

        JLabel image = new JLabel(new ImageBuilder(userDTO.getImageURL(), ImageBuilder.URL).changeCircleImage(60).getImageIcon());
        JLabel name = new LabelBuilder(userDTO.getName()).setFont(14).getLabel();
        JLabel id = new LabelBuilder(userDTO.getId()).setFont(12).setColor(Color.gray).getLabel();
        JLabel email = new LabelBuilder(userDTO.getEmail()).setFont(12).setColor(Color.gray).getLabel();

        Panel info = new Panel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        info.add(name);
        info.add(id);
        info.add(email);

        JLabel more = new JLabel(new ImageBuilder("more_vert", ImageBuilder.ICON).setSize(20, 20).getImageIcon());

        add(cover(image, info), BorderLayout.WEST);
        add(cover(more), BorderLayout.EAST);
    }
}
