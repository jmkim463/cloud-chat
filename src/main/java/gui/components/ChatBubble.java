package gui.components;

import utils.MessageType;
import utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ChatBubble extends JPanel {

    private final static int MAX_LINE_TEXT_COUNT = 40;

    private final static Color ME_BACKGROUND = 
    private final static Color OTHER_BACKGROUND = new Color(239, 239, 239);

    public static void main(String[] args) {
        Frame frame = new Frame();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        for(int i = 0; i < 1; i++) {
            panel.add(Utils.coverComponentsFlowlayout(new ChatBubble("안녕하세요 ~~~~~~~~~~~~~", MessageType.Me)));
        }

        frame.add(new Scroll(Utils.coverComponentsFlowlayout(panel)));
        frame.setVisible(true);
    }

    public ChatBubble(String text, MessageType messageType) {
        JTextArea textArea = new JTextArea(text);
        textArea.setFont(new Font("나눔고딕", 0, 15));
        textArea.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
        textArea.setOpaque(false);
        textArea.setMinimumSize(new Dimension(0, 0));
        textArea.setSelectionColor(Color.yellow);
        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                e.setKeyChar((char) 0);
            }
        });

        if(textArea.getText().length() > MAX_LINE_TEXT_COUNT) {
            textArea.setLineWrap(true);
            textArea.setColumns(MAX_LINE_TEXT_COUNT);
        }

        setBackground(new Color(239, 239, 239));
        add(textArea);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        Dimension dimension = getPreferredSize();
        int w = dimension.width, h = dimension.height;

        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, w, h, 25, 25);
    }
}
