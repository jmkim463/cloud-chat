package chat.gui.layout.account.view;

import chat.gui.components.FileSelector;
import chat.gui.components.LabelBuilder;
import chat.gui.components.Panel;
import chat.gui.utils.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class UserImage extends Panel {

    private final static int SIZE = 100;
    private final static ImageIcon DEFAULT_USER_ICON = new ImageIcon(
            ImageUtils.getDefaultUserImageIcon().getImage().getScaledInstance(SIZE, SIZE, Image.SCALE_SMOOTH));

    private JLabel userImageIconLabel;

    private String selectedImagePath = null;

    public UserImage() {
        init();
    }

    private void init() {
       setLayout(new FlowLayout(FlowLayout.LEFT));

       userImageIconLabel = new LabelBuilder(DEFAULT_USER_ICON)
               .setClickListener(e -> changeImage()).getLabel();

       add(userImageIconLabel);
    }

    private void changeImage() {
        try(FileSelector selector = new FileSelector()) {
            selector.show();

            String path = selector.getPath();
            String name = selector.getFile();

            if(path == null) {
                return;
            }

            if(!(name.endsWith(".jpg") || name.endsWith(".png"))) {
                return;
            }

            userImageIconLabel.setIcon(ImageUtils.changeToCircleImage(SIZE, new ImageIcon(path)));
            selectedImagePath = path;

        } catch (Exception e) {}
    }

    public String getSelectedImagePath() {
        return selectedImagePath;
    }
}
