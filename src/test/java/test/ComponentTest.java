package test;

import gui.layout.SideBar;
import gui.layout.chatting.ChatBubble;
import gui.components.Frame;
import gui.components.Scroll;
import gui.layout.chatting.ChatField;
import gui.layout.chatting.ChatRoomList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import utils.ImageUtils;
import utils.MessageType;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ComponentTest {


    @AfterEach
    void sleep() throws InterruptedException {
        Thread.sleep(10000);
    }

    @Test
    void testChatRoom() {
        Frame frame = new Frame();

        ChatField chatField = new ChatField();

        for(int i = 0; i < 20; i++) {
            Random rnd = new Random();

            chatField.addMessage("히히히 안뇽안뇽", rnd.nextInt(2) == 0 ? MessageType.Me : MessageType.Other);
        }

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(chatField);
        panel.add(new ChatRoomList(), BorderLayout.WEST);

        JPanel main = new JPanel(new BorderLayout());
        main.add(panel);
        main.add(new SideBar(), BorderLayout.WEST);

        frame.add(main);

        frame.setVisible(true);
    }
    @Test
    void circleImageTest() {
         Frame frame = new Frame();

         JPanel panel = new JPanel();
         panel.add(new JLabel(ImageUtils.changeToCircleImage(100, new ImageIcon(ImageUtils.getURL("hamburger.jpg")))));
         panel.add(new JLabel(new ImageIcon(new ImageIcon(ImageUtils.getURL("hamburger.jpg")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH))));
         panel.setBackground(Color.red);
         frame.add(panel);

         frame.setVisible(true);
    }

    @Test
    void chatBubbleTest()  {
        Frame frame = new Frame();

        JPanel panel = new JPanel(new BorderLayout());

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

        for(int i = 0; i < 10; i++) {
            Random rnd = new Random();

            JPanel p = new ChatBubble("히히히 안뇽안뇽", rnd.nextInt(2) == 0 ? MessageType.Me : MessageType.Other);
            panel1.add(p);
        }

        JTextField text = new JFormattedTextField();
        text.setPreferredSize(new Dimension(500, 100));
        panel.add(new Scroll(panel1));
        panel.add(text, BorderLayout.SOUTH);

        frame.add(panel);

        frame.setVisible(true);
    }

    @Test
    void showAllFonts() {
        Frame frame = new Frame();
        JPanel panel = new JPanel(new GridLayout(0, 1));
        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();

        for(Font font : e.getAllFonts()) {
            JLabel label = new JLabel("<html>"  + font.getName() + "</html>");
            label.setFont(new Font(font.getName(), 1, 20));
            panel.add(label);
        }

        frame.add(new Scroll(panel));
        frame.setVisible(true);
    }
}
