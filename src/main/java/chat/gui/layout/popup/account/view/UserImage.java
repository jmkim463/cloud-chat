package chat.gui.layout.popup.account.view;

import chat.gui.components.FileSelector;
import chat.gui.components.ImageBuilder;
import chat.gui.components.LabelBuilder;
import chat.gui.components.Panel;

import javax.swing.*;
import java.awt.*;

public class UserImage extends Panel {

    private final static int SIZE = 100;
    private final static ImageIcon DEFAULT_USER_ICON = new ImageBuilder("default_user", ImageBuilder.ICON)
            .setSize(SIZE, SIZE).getImageIcon();

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

            userImageIconLabel.setIcon(
                    new ImageBuilder(path, ImageBuilder.FILE).changeCircleImage(SIZE).getImageIcon());
            selectedImagePath = path;

        } catch (Exception e) {}
    }

    public String getSelectedImagePath() {
        return selectedImagePath;
    }
}
