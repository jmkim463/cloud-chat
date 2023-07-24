package gui.layout;

import gui.Main;
import gui.components.Frame;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends Frame {

    private static MainFrame instance;

    JPanel panel = new JPanel(new BorderLayout());
    SideBar sideBar = new SideBar();

    public static MainFrame getInstance() {
        if(instance == null) {
            instance = new MainFrame();
        }
        return instance;
    }

    public MainFrame() {
        init();
    }

    private void init() {
        add(panel);
    }

    public void changeScreenWithSideBar(JPanel target) {
        panel.removeAll();
        panel.add(sideBar, BorderLayout.WEST);
        panel.add(target);

        revalidate();
        repaint();
    }

    public void changeScreen(JPanel target) {
        panel.removeAll();

        panel.add(target);

        revalidate();
        repaint();
    }
}
