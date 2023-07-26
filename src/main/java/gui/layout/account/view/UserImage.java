package gui.layout.account.view;

import gui.components.LabelBuilder;
import gui.components.Panel;
import utils.ImageUtils;

import javax.swing.*;
import java.awt.*;

public class UserImage extends Panel {

    public final static int SIZE = 150;

    public UserImage() {
        init();
    }

    private void init() {
       setLayout(new FlowLayout(FlowLayout.LEFT));

       JLabel label = new LabelBuilder(new ImageIcon(
               ImageUtils.getDefaultUserImageIcon().getImage().getScaledInstance(SIZE, SIZE, Image.SCALE_SMOOTH))).getLabel();

       label.setText("dksl qn");

       add(label);
    }

}
