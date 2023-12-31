package test;

import chat.gui.layout.sidebar.SideBarView;
import chat.gui.components.Frame;
import chat.gui.components.Panel;
import chat.gui.components.Scroll;
import chat.gui.components.PopupMenu;
import chat.gui.layout.chat.view.ChatField;
import chat.gui.layout.chat.view.ChatRoomList;
import chat.gui.utils.Colors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicMenuItemUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

public class ComponentTest {


    @AfterEach
    void sleep() throws InterruptedException {
        Thread.sleep(1000 * 10);
    }

    @Test
    void testPopupMenu() {
        JMenuItem item1 = new JMenuItem("챗팅하기");
        item1.setFont(new chat.gui.components.Font(12));
        item1.setBorderPainted(false);
        item1.setBackground(Color.white);
        item1.setUI(new BasicMenuItemUI() {
            @Override
            protected void paintMenuItem(Graphics g, JComponent c, Icon checkIcon, Icon arrowIcon, Color background, Color foreground, int defaultTextIconGap) {
                super.paintMenuItem(g, c, checkIcon, arrowIcon, Color.white, foreground, defaultTextIconGap);
            }
        });
        item1.setOpaque(false);

        JPopupMenu menu = new JPopupMenu();
        menu.setBackground(Color.white);
        menu.setBorder(new LineBorder(Color.black));
        menu.add(item1);

        Panel panel = new Panel();
        panel.setBackground(Color.RED);
        panel.setPreferredSize(new Dimension(200, 200));
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menu.show(panel, e.getX(), e.getY());
            }
        });

        JPanel p = panel.cover();
        p.setBackground(Color.white);

        Frame frame = new Frame();
        frame.add(p);
        frame.setVisible(true);
    }

    @Test
    void shadowBorder() {

        MatteBorder border = new MatteBorder(0, 0,0,0, (Color) null) {
            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                Color shadow = new Color(0, 0, 0, 100);

                g.setColor(Colors.getBorderLineColor());
                g.fillRect(0, height - 1, width - 0, 1);

                g.setColor(shadow);
                g.fillRect(0, height - 5, width - 0, 5);
            }
        };

        Panel panel = new Panel();
        panel.setBackground(Color.RED);
        panel.setPreferredSize(new Dimension(200, 200));
        panel.setBorder(border);

        JPanel p = panel.cover();
        p.setBackground(Color.white);

        Frame frame = new Frame();
        frame.add(p);
        frame.setVisible(true);
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

        //    chatField.addMessage("히히히 안뇽안뇽", rnd.nextInt(2) == 0 ? MessageType.ME : MessageType.OTHER);
        }

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(chatField);
        panel.add(new ChatRoomList(), BorderLayout.WEST);

        JPanel main = new JPanel(new BorderLayout());
        main.add(panel);
        main.add(new SideBarView(), BorderLayout.WEST);

        frame.add(main);

        frame.setVisible(true);
    }
    @Test
    void circleImageTest() {
         Frame frame = new Frame();

         /*JPanel panel = new JPanel();
         panel.add(new JLabel(Icons.changeToCircleImage(100, new ImageIcon(Icons.getURL("hamburger.jpg")))));
         panel.add(new JLabel(new ImageIcon(new ImageIcon(Icons.getURL("hamburger.jpg")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH))));
         panel.setBackground(Color.red);
         frame.add(panel);*/
         frame.setVisible(true);
    }

    @Test
    void chatBubbleTest()  {
        Frame frame = new Frame();

        JPanel panel = new JPanel(new BorderLayout());

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));


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
