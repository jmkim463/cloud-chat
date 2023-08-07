package gui.layout;

import gui.Main;
import gui.components.Frame;
import gui.layout.login.LoginController;
import module.SocketManager;

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

    @Override
    public void dispose() {
        super.dispose();

        SocketManager.getInstance().shutDown();

        instance = null;
    }

    public void changeScreenWithSideBar(JPanel target) {
        panel.removeAll();
        panel.add(sideBar, BorderLayout.WEST);
        panel.add(target);

        revalidate();
        repaint();
    }
}
