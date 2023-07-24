package gui.layout.login;

import gui.components.Button;
import gui.components.LabelFactory;
import jdk.jshell.execution.Util;
import utils.Colors;
import utils.ImageUtils;
import utils.Utils;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;
import java.awt.*;

public class LoginField extends JPanel {

    JTextField id = new JTextField();
    JTextField password = new JPasswordField();

    public LoginField() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout());

        add(new ImageBar(), BorderLayout.WEST);
        add(new InputField());
    }

    class InputField extends JPanel {

        public InputField() {
            init();
        }

        private void init() {
            setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

            JPanel grid = new JPanel(new GridLayout(0, 1));

            id.setPreferredSize(new Dimension(300, 28));
            id.setFont(LabelFactory.getLabelDefaultFont());
            id.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Colors.getBorderLineColor()));
            password.setPreferredSize(new Dimension(300, 28));
            password.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Colors.getBorderLineColor()));

            grid.add(LabelFactory.createLabel("User ID", 13, Color.lightGray));
            grid.add(id);
            grid.add(new JPanel());
            grid.add(LabelFactory.createLabel("Password", 13, Color.lightGray));
            grid.add(password);
            grid.add(new JPanel());

            Button btn = new Button(200, 35, "Log in");
            btn.setCheckEmptyTextComponent(new JTextComponent[]{id, password});
            btn.setActionListener(e -> {

            });

            JLabel signup = LabelFactory.createLabel("Sign Up", new Color(71, 126, 251));

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            panel.add(Utils.coverComponentsFlowlayout(LabelFactory.createLabel("CLOUD CHAT", 1, 50)));
            panel.add(Utils.getEmptyComponent(50));
            panel.add(Utils.coverComponentsFlowlayout(LabelFactory.createLabel("Welcome to Cloud Chat", 20, Color.gray)));
            panel.add(Utils.getEmptyComponent(50));
            panel.add(Utils.coverComponentsFlowlayout(grid));
            panel.add(Utils.coverComponentsFlowlayout(btn));
            panel.add(Utils.getEmptyComponent(80));
            panel.add(Utils.coverComponentsFlowlayout(LabelFactory.createLabel("Don't have an account yet?", 13, Color.gray), signup));

            add(panel);
        }
    }

    class ImageBar extends JPanel {

        public ImageBar() {
            init();
        }

        private void init() {
            setBackground(new Color(71, 126, 251));
            setLayout(new FlowLayout(FlowLayout.CENTER, 0, 150));
            setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

            JLabel image = new JLabel(
                    ImageUtils.setImageIconSize(400, 275,
                            new ImageIcon(ImageUtils.getURL("login-image.png"))));

            JPanel grid = new JPanel(new GridLayout(0, 1, 0, 0));
            grid.setBackground(getBackground());
            grid.setBorder(BorderFactory.createEmptyBorder(50, 0, 0 ,0));

            JLabel label1 = LabelFactory.createLabel("test label maker easy comment", 1, 15, Color.white);
            JLabel label2 = LabelFactory.createLabel("ejejgrp Tmqmsmrp whgrp", 1,15, Color.white);

            grid.add(LabelFactory.setLabelHorizontalCenter(label1));
            grid.add(LabelFactory.setLabelHorizontalCenter(label2));

            JPanel panel = new JPanel(new BorderLayout());
            panel.setBackground(getBackground());
            panel.add(image);
            panel.add(grid, BorderLayout.SOUTH);

            add(panel);
        }
    }
}
