package chat.gui.layout.popup.group.view;

import chat.gui.components.ImageBuilder;
import chat.gui.components.LabelBuilder;
import chat.gui.components.Panel;
import chat.gui.components.RadioButton;
import chat.gui.utils.Colors;
import chat.module.dto.UserDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserItem extends Panel {

    private final UserDTO userDTO;
    private final JPanel checked;

    private boolean isSelected = false;

    public UserItem(UserDTO userDTO) {
        this.userDTO = userDTO;
        this.checked = new JPanel();

        init();
    }

    private void init() {
        setLayout(new BorderLayout());

        JLabel profile = new JLabel(new ImageBuilder(userDTO.getImageURL(), ImageBuilder.URL).changeCircleImage(60).getImageIcon());
        JLabel name = new LabelBuilder(userDTO.getName()).setFont(15).getLabel();

        checked.setPreferredSize(new Dimension(5, 55));
        checked.setBackground(Colors.getButtonBackgroundColor());
        checked.setVisible(isSelected);

        add(cover(profile, name), BorderLayout.WEST);
        add(cover(checked), BorderLayout.EAST);

        addMouseListener(new ClickListener());
    }

    class ClickListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            isSelected = !isSelected;

            checked.setVisible(isSelected);
        }
    }

    public boolean isSelected() {
        return isSelected;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }
}
