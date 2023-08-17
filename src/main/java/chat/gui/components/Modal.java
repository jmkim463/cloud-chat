package chat.gui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Modal extends JDialog {

    public Modal(int w, int h) {
        setModal(true);
        setSize(w, h);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setIconImage(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB));
    }

}
