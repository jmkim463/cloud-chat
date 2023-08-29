package chat.gui.layout.friend.view;

import chat.gui.components.LabelBuilder;
import chat.gui.components.Panel;
import chat.gui.components.ShadowBorder;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FriendGroup extends Panel {

    private final static String DOWN = "▼";
    private final static String UP = "▲";

    private final JLabel titleLabel;
    private final JLabel countLabel;
    private final JPanel listPanel;
    private final JLabel arrowButton;

    public FriendGroup(String headerText) {
        this.arrowButton = new LabelBuilder(DOWN).setFont(30).setClickListener(e -> clickArrowButton()).getLabel();

        titleLabel = new LabelBuilder(headerText).setFont(1, 16).getLabel();
        countLabel = new LabelBuilder("0명").setFont(1, 16).getLabel();
        listPanel = new JPanel();

        init();
    }

    private void init() {
        setLayout(new BorderLayout());

        listPanel.setLayout(new GridLayout(0, 1));
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

    public void setList(List<JPanel> list) {
        listPanel.removeAll();

        for (JPanel item : list) {
            listPanel.add(item);
        }

        setTitleBar();

        revalidate();
        repaint();
    }

    public void setTitleBar() {
        int cnt = listPanel.getComponentCount();

        countLabel.setText(cnt + "명");

        if(cnt == 0 || !listPanel.isVisible()) {
            setTextColor(Color.lightGray);
        } else {
            setTextColor(Color.black);
        }
    }

    public void clickArrowButton() {
        switch (arrowButton.getText()) {
            case DOWN -> {
                arrowButton.setText(UP);
                listPanel.setVisible(false);
            }
            case UP -> {
                arrowButton.setText(DOWN);
                listPanel.setVisible(true);
            }
        }
        setTitleBar();
    }

    private void setTextColor(Color color) {
        titleLabel.setForeground(color);
        countLabel.setForeground(color);
    }
}
