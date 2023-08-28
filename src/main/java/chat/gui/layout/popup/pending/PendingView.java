package chat.gui.layout.popup.pending;

import chat.gui.components.*;
import chat.gui.components.Panel;
import chat.gui.layout.popup.pending.view.UserItem;
import chat.module.dto.UserDTO;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicRadioButtonUI;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class PendingView extends Panel {

    private final Scroll scroll;
    private final Panel resultPanel;
    private final JTextField textField;

    private final JLabel emptyLabel;

    public PendingView() {
        resultPanel = new Panel(new GridLayout(0, 1));
        scroll = new Scroll(resultPanel.cover(FlowLayout.LEFT));
        textField = new JTextField();

        emptyLabel = new LabelBuilder(
            "<html><div style='text-align: center;'>친구 추가할 회원의 아이디 또는 " +
                "<br>이메일을 입력해주세요.</div></html>").getLabel();;

        init();
    }

    private void init() {
        setLayout(new BorderLayout());

        textField.setPreferredSize(new Dimension(250, 28));

        Panel panel = new Panel(new BorderLayout());
        panel.add(cover(emptyLabel), BorderLayout.NORTH);
        panel.add(scroll);

        add(cover(textField), BorderLayout.NORTH);
        add(panel);
    }

    public void addEnterKeyListener(ActionListener actionListener) {
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == 10) {
                    actionListener.actionPerformed(null);
                }
            }
        });
    }

    public void addResultList(List<UserItem> list) {
        resultPanel.removeAll();

        for(UserItem item : list) {
            resultPanel.add(item);
        }

        emptyLabel.setVisible(false);

        revalidate();
        repaint();
    }

    public void initResultPanel() {
        resultPanel.removeAll();

        textField.setText("");
        emptyLabel.setVisible(true);

        revalidate();
        repaint();
    }

    public String getKeyword() {
        return textField.getText();
    }

}
