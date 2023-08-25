package chat.gui.layout.friend.view;

import chat.gui.components.ImageBuilder;
import chat.gui.components.LabelBuilder;
import chat.gui.components.Panel;
import chat.gui.components.ShadowBorder;
import chat.gui.components.button.Button;
import chat.gui.utils.Colors;
import chat.module.dto.UserDTO;

import java.awt.*;
import java.util.List;

import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class FriendList extends Panel {

    private final Group pending;
    private final Group accepted;


    public FriendList() {
        accepted = new Group("친구");
        pending = new Group("대기 중인 친구");

        init();
    }

    private void init() {
        setLayout(new BorderLayout());

        add(pending, BorderLayout.NORTH);
        add(accepted);
    }

    public void refreshPendingFriendList(List<UserDTO> list) {
        JPanel panel = pending.getListPanel();
        panel.removeAll();

        for(UserDTO user : list) {
            PendingFriend item = new PendingFriend(user);

            panel.add(item);
        }

        revalidate();
        repaint();
    }

    public void refreshAcceptedFriendList(List<UserDTO> list) {
        JPanel panel = accepted.getListPanel();
        panel.removeAll();

        for(UserDTO user : list) {
            AcceptedFriend item = new AcceptedFriend(user);

            panel.add(item);
        }

        revalidate();
        repaint();
    }

    class Group extends Panel {

        private final static String DOWN = "▼";
        private final static String UP = "▲";

        private final JLabel titleLabel;
        private final JLabel countLabel;
        private final JPanel listPanel;
        private final JLabel arrowButton;

        public Group(String headerText) {
            this.arrowButton = new LabelBuilder(DOWN).setFont(30).setClickListener(e -> clickArrowButton()).getLabel();

            titleLabel = new LabelBuilder(headerText).setFont(1, 16).getLabel();
            countLabel = new LabelBuilder("0명").setFont(1, 16).getLabel();
            listPanel = new JPanel();

            init();
        }

        private void init() {
            setLayout(new BorderLayout());

            listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
            listPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

            arrowButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
            Dimension dimension = arrowButton.getPreferredSize();

            Panel header = new Panel(new BorderLayout());
            header.setBorder(new ShadowBorder(3));
            header.add(getEmpty(dimension.width + 20, dimension.height), BorderLayout.WEST);
            header.add(cover(titleLabel, countLabel));
            header.add(arrowButton, BorderLayout.EAST);
            header.add(getEmpty(20), BorderLayout.SOUTH);

            add(header, BorderLayout.NORTH);
            add(listPanel);
        }

        public void clickArrowButton() {
            switch (arrowButton.getText()) {
                case DOWN -> {
                    arrowButton.setText(UP);
                    listPanel.setVisible(false);
                    setTextColor(Color.lightGray);
                }
                case UP -> {
                    arrowButton.setText(DOWN);
                    listPanel.setVisible(true);
                    setTextColor(Color.black);
                }
            }
        }

        private void setTextColor(Color color) {
            titleLabel.setForeground(color);
            countLabel.setForeground(color);
        }

        public JPanel getListPanel() {
            return listPanel;
        }
    }

    class PendingFriend extends Panel {

        private final UserDTO userDTO;

        public PendingFriend(UserDTO userDTO) {
            this.userDTO = userDTO;


            init();
        }

        private void init() {
            setLayout(new BorderLayout());

            JLabel image = new JLabel(new ImageBuilder(userDTO.getImageURL(), ImageBuilder.URL).changeCircleImage(50).getImageIcon());

            Panel info = new Panel();
            info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
            info.add(new LabelBuilder(userDTO.getName()).getLabel());

            Button button = new Button(60, 25, 15, "추가");
            button.setFont(12);

            JLabel cancel = new JLabel(new ImageBuilder("cancel", ImageBuilder.ICON).setSize(15, 15).changeImageColor(Color.lightGray).getImageIcon());

            add(cover(image, info), BorderLayout.WEST);
            add(cover(button, cancel), BorderLayout.EAST);
        }
    }

    class AcceptedFriend extends Panel {

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
            add(more, BorderLayout.EAST);
        }
    }

}
