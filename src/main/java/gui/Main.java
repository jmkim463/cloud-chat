package gui;

import gui.layout.chatting.view.ChatBubble;
import gui.components.Frame;
import gui.components.Scroll;
import utils.MessageType;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame();

        JPanel panel = new JPanel(new BorderLayout());

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

        for(int i = 0; i < 10; i++) {
            Random rnd = new Random();

            JPanel p = new ChatBubble("히히히 안뇽안뇽", rnd.nextInt(2) == 0 ? MessageType.Me : MessageType.Other);

            System.out.println(p.getSize());
            panel1.add(p);
        }

        JPanel panel2 = new JPanel(new BorderLayout(10, 10));

        JTextArea textField = new JTextArea();
        textField.setBorder(new LineBorder(new Color(229, 229, 229)));
        textField.setPreferredSize(new Dimension(500, 80));

        JButton btn = new JButton("보내기");
        btn.addActionListener(v -> {
            panel1.add(new ChatBubble(textField.getText(), MessageType.Me));

            panel1.revalidate();
            panel1.repaint();
        });

        panel2.add(textField);
        panel2.add(btn, BorderLayout.EAST);


        panel.add(new Scroll(panel1));
        panel.add(panel2, BorderLayout.SOUTH);

        frame.add(panel);

        frame.setVisible(true);
    }
}
