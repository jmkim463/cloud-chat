package chat.gui.layout.popup.group;

import chat.gui.components.Panel;
import chat.gui.components.Scroll;
import chat.gui.components.button.Button;
import chat.gui.layout.popup.group.view.UserItem;
import chat.module.dto.UserDTO;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GroupView extends Panel {

    private final Panel listPanel;
    private final Scroll scroll;
    private final JTextField textField;
    private final Button button;

    private List<UserItem> list;

    public GroupView() {
        listPanel = new Panel();
        scroll = new Scroll(listPanel);
        textField = new JTextField();
        button = new Button(150, 28, "완료");

        init();
    }

    private void init() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

        add(textField, BorderLayout.NORTH);
        add(scroll);
        add(cover(FlowLayout.RIGHT, 5, 5, button), BorderLayout.SOUTH);
    }

    public void setFriendList(List<UserItem> list) {
        listPanel.removeAll();

        this.list = list;

        for(UserItem item : list) {
            listPanel.add(item);
        }

        revalidate();
        repaint();
    }

    public String getGroupName() {
        return textField.getText();
    }

    public List<Long> getSelectedList() {
        List<Long> userList = new ArrayList<>();

        for(UserItem item : list) {
            if(item.isSelected()) {
                userList.add(item.getUserDTO().getNo());
            }
        }

        return userList;
    }

    public Button getButton() {
        return button;
    }
}
