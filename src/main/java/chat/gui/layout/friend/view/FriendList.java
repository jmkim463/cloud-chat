package chat.gui.layout.friend.view;

import chat.gui.components.ImageBuilder;
import chat.gui.components.LabelBuilder;
import chat.gui.components.Panel;
import chat.gui.components.button.Button;
import chat.module.dto.UserDTO;

import java.awt.*;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;

public class FriendList extends Panel {

    private final Panel pendingListPanel;
    private final Panel acceptedListPanel;

    private final JLabel pendingLabel;
    private final JLabel acceptedLabel;

    public FriendList() {
        pendingListPanel = new Panel();
        acceptedListPanel = new Panel();

        pendingLabel = new LabelBuilder("0명").getLabel();
        acceptedLabel = new LabelBuilder("0명").getLabel();

        init();
    }

    private void init() {
        setLayout(new BorderLayout());

        pendingListPanel.setLayout(new BoxLayout(pendingListPanel, BoxLayout.Y_AXIS));
        acceptedListPanel.setLayout(new BoxLayout(acceptedListPanel, BoxLayout.Y_AXIS));

        Panel header1 = new Panel(new BorderLayout());
        header1.add(cover(pendingLabel));

        Panel header2 = new Panel(new BorderLayout());
        header2.add(cover(acceptedLabel));

        Panel pendingPanel = new Panel(new BorderLayout());
        Panel acceptedPanel = new Panel(new BorderLayout());

        pendingPanel.add(header1, BorderLayout.NORTH);
        pendingPanel.add(pendingListPanel);

        acceptedPanel.add(header2, BorderLayout.NORTH);
        acceptedPanel.add(acceptedListPanel);

        add(pendingPanel, BorderLayout.NORTH);
        add(acceptedPanel);
    }

    public void refreshPendingFriendList(List<UserDTO> list) {
        pendingListPanel.removeAll();

        for(UserDTO user : list) {
            PendingFriend item = new PendingFriend(user);

            pendingListPanel.add(item);
        }

        revalidate();
        repaint();
    }

    public void refreshAcceptedFriendList(List<UserDTO> list) {
        acceptedListPanel.removeAll();

        for(UserDTO user : list) {
            AcceptedFriend item = new AcceptedFriend(user);

            acceptedListPanel.add(item);
        }

        revalidate();
        repaint();
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

            Button button = new Button(100, 28, 15, "추가");
            JLabel cancel = new JLabel(new ImageBuilder("cancel", ImageBuilder.ICON).setSize(40, 40).getImageIcon());

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
            JLabel name = new LabelBuilder(userDTO.getName()).getLabel();
            JLabel id = new LabelBuilder(userDTO.getId()).setFont(10).setColor(Color.gray).getLabel();
            JLabel email = new LabelBuilder(userDTO.getEmail()).setFont(10).setColor(Color.gray).getLabel();

            Panel info = new Panel();
            info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
            info.add(name);
            info.add(id);
            info.add(email);

            add(cover(image, info), BorderLayout.WEST);
        }
    }

}
