package test;

import gui.layout.SideBar;
import gui.layout.chatting.view.ChatBubble;
import gui.components.Frame;
import gui.components.Scroll;
import gui.layout.chatting.view.ChatField;
import gui.layout.chatting.view.ChatRoomList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import gui.utils.ImageUtils;
import gui.utils.MessageType;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class ComponentTest {


    @AfterEach
    void sleep() throws InterruptedException {
        Thread.sleep(999999);
    }

    @Test
    void showURLImageIcon() {
        Frame frame = new Frame();

        Panel panel = new Panel();

        try {
//            URL imageUrl = new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQikT2F-SoptowIYNW3dsQDHecNmUZCFsv9Og&usqp=CAU");
//            ImageIcon imageIcon = new ImageIcon(imageUrl);
//            Image image = imageIcon.getImage();
//
//            // ImageObserver를 이용하여 이미지 로드 기다리기
//            ImageObserver observer = (img, infoflags, x, y, width, height) -> {
//                if ((infoflags & ImageObserver.ALLBITS) != 0) {
//                    // 이미지가 로드된 후에 실행되는 블록
//                    JLabel label = new JLabel(new ImageIcon(image.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
//                    panel.add(label);
//                    panel.add(new JLabel("왜 안나와"));
//                    frame.revalidate();
//
//                    System.out.println("Test");
//                    return false;
//                }
//                System.out.println("test");
//                return true;
//            };
//
//            // ImageObserver를 이용하여 이미지 로드 기다리기
//            image.getWidth(observer);
//            image.getHeight(observer);

            JLabel label = new JLabel(new ImageIcon(new ImageIcon(new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQikT2F-SoptowIYNW3dsQDHecNmUZCFsv9Og&usqp=CAU"))
                    .getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));

            panel.add(label);
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame.add(panel);
        frame.setVisible(true);
    }

    @Test
    void testImageIconToByteArray() throws IOException {
        ImageIcon icon = new ImageIcon(new ImageIcon("C:\\햄버거.jpg")
                .getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));

        BufferedImage bi = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_BGR);
        Graphics2D g2 = bi.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        icon.paintIcon(null, g2, 0, 0);
        g2.dispose();

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ImageIO.write(bi, ".jpg", stream);

        System.out.println(stream.toByteArray().length);
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
            JLabel label = new JLabel("<html>"  + font.getName()+ " CLOUD CHAT" + "</html>");
            label.setFont(new Font(font.getName(), 1, 20));
            panel.add(label);
        }

        frame.add(new Scroll(panel));
        frame.setVisible(true);
    }
}
