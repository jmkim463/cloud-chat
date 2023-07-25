package gui.layout.login;

import gui.components.Button;
import gui.components.Font;
import gui.components.LabelBuilder;
import gui.components.Panel;
import utils.Colors;
import utils.ImageUtils;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginField extends Panel {

    private JTextField id = new JTextField();
    private JTextField password = new JPasswordField();
    private ActionListener actionListener;

    public LoginField() {
        init();
    }

    private void init() {
        setLayout(new BorderLayout());

        add(new ImageBar(), BorderLayout.WEST);
        add(new InputField());
    }

    public String getID() {
        return id.getText();
    }

    public String getPassword() {
        return password.getText();
    }

    public void setClickListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    class InputField extends Panel {

        public InputField() {
            init();
        }

        private void init() {
            setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

            id.setPreferredSize(new Dimension(300, 28));
            id.setFont(new Font());
            id.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Colors.getBorderLineColor()));
            password.setPreferredSize(new Dimension(300, 28));
            password.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Colors.getBorderLineColor()));

            Panel grid = new Panel(new GridLayout(0, 1));
            grid.add(new LabelBuilder("User ID").setFont(13).setColor(Color.lightGray).getLabel());
            grid.add(id);
            grid.add(new JPanel());
            grid.add(new LabelBuilder("Password").setFont(13).setColor(Color.lightGray).getLabel());
            grid.add(password);
            grid.add(new JPanel());

            Button btn = new Button(200, 35, "Log in");
            btn.setCheckEmptyTextComponent(new JTextComponent[]{id, password});
            btn.setActionListener(e -> {
                if(actionListener != null) {
                    actionListener.actionPerformed(null);
                }
            });

            JLabel signup = new LabelBuilder("Sign Up").setColor(new Color(71, 126, 251)).getLabel();

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            panel.add(cover(new LabelBuilder("CLOUD CHAT").setFont("Edu SA Beginner", 1, 50).getLabel()));
            panel.add(getEmpty(50));
            panel.add(cover(new LabelBuilder("Welcome to Cloud Chat").setFont(20).setColor(Color.gray).getLabel()));
            panel.add(getEmpty(50));
            panel.add(cover(grid));
            panel.add(cover(btn));
            panel.add(getEmpty(80));
            panel.add(cover(new LabelBuilder("Don't have an account yet?").setFont(13).setColor(Color.gray).getLabel(), signup));

            add(panel);
        }
    }

    class ImageBar extends Panel {

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

            Panel grid = new Panel(new GridLayout(0, 1, 0, 0));
            grid.setBackground(getBackground());
            grid.setBorder(BorderFactory.createEmptyBorder(50, 0, 0 ,0));

            grid.add(new LabelBuilder("test label maker easy comment")
                    .setFont(1, 15).setColor(Color.white).setHorizontalCenter().getLabel());
            grid.add(new LabelBuilder("ejejgrp Tmqmsmrp whgrp")
                    .setFont(1, 15).setColor(Color.white).setHorizontalCenter().getLabel());

            Panel panel = new Panel(new BorderLayout());
            panel.setBackground(getBackground());
            panel.add(image);
            panel.add(grid, BorderLayout.SOUTH);

            add(panel);
        }
    }
}
