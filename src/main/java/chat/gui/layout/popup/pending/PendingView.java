package chat.gui.layout.popup.pending;

import chat.gui.components.Panel;
import chat.gui.components.Scroll;
import chat.gui.components.ShadowBorder;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PendingView extends Panel {

    private final Scroll scroll;
    private final Panel resultPanel;
    private final JTextField textField;

    public PendingView() {
        scroll = new Scroll();
        resultPanel = new Panel(new GridLayout(0, 1));
        textField = new JTextField();

        init();
    }

    private void init() {
        setLayout(new BorderLayout());

        scroll.setViewportView(resultPanel);

        Panel header = new Panel();
        header.setBorder(new ShadowBorder(3));
        header.add(textField);

        add(scroll);
        add(header, BorderLayout.NORTH);

    }

}
