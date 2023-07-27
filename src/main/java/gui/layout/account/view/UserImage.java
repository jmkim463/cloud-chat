package gui.layout.account.view;

import gui.components.*;
import gui.components.Font;
import gui.components.Panel;
import utils.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FilenameFilter;

public class UserImage extends Panel {

    private final static int SIZE = 100;
    private final static ImageIcon DEFAULT_USER_ICON = new ImageIcon(
            ImageUtils.getDefaultUserImageIcon().getImage().getScaledInstance(SIZE, SIZE, Image.SCALE_SMOOTH));

    private JLabel userImageIconLabel;

    public UserImage() {
        init();
    }

    private void init() {
       setLayout(new FlowLayout(FlowLayout.LEFT));


       userImageIconLabel = new LabelBuilder(DEFAULT_USER_ICON)
               .setClickListener(this::changeImage)
               .getLabel();

       add(userImageIconLabel);
    }

    private void changeImage() {
        try(FileSelector selector = new FileSelector()) {
            selector.show();

            userImageIconLabel.setIcon(ImageUtils.changeToCircleImage(SIZE, new ImageIcon(selector.getFile())));

        } catch (Exception e) {}
    }
}
