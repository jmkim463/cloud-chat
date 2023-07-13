package test;

import gui.components.Frame;
import gui.components.Scroll;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

public class ComponentTest {


    @Test
    void showAllFonts() throws InterruptedException {
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

        Thread.sleep(1000 * 10);
    }
}
