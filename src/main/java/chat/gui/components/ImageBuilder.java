package chat.gui.components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageBuilder {

    public final static int FILE = 0;
    public final static int URL = 1;
    public final static int ICON = 2;
    public final static int RESOURCES = 3;

    ImageIcon icon;

    public ImageBuilder(String str, int type) {
        switch (type) {
            case FILE -> icon = new ImageIcon(str);
            case URL -> {
                try {
                    icon = new ImageIcon(new URL(str));
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
            case ICON -> icon = new ImageIcon(ImageBuilder.class.getClassLoader().getResource("icon/" + str + ".png").getPath());
            case RESOURCES -> icon = new ImageIcon(ImageBuilder.class.getClassLoader().getResource(str + ".png").getPath());
        }
    }

    public ImageBuilder setSize(int w, int h) {
        icon = new ImageIcon(icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
        return this;
    }

    public ImageBuilder changeCircleImage(int size) {
        Graphics2D g2;

        BufferedImage bi1 = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        g2 = bi1.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.red);
        g2.fillOval(0, 0, size, size);
        g2.dispose();

        BufferedImage bi2 = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        g2 = bi2.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawImage(new ImageIcon(icon.getImage().getScaledInstance(size, size, Image.SCALE_REPLICATE)).getImage(), 0, 0, null);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN));
        g2.drawImage(bi1, 0, 0, null);
        g2.dispose();

        icon = new ImageIcon(bi2);

        return this;
    }

    public ImageBuilder changeImageColor(Color color) {
        BufferedImage bi = new BufferedImage(
                icon.getIconWidth(),
                icon.getIconHeight(),
                BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2 = bi.createGraphics();
        icon.paintIcon(null, g2, 0, 0);
        g2.dispose();

        WritableRaster raster = bi.getRaster();

        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();

        for(int i = 0; i < bi.getWidth(); i++) {
            for(int j = 0; j < bi.getHeight(); j++) {
                int[] arr = raster.getPixel(i, j, (int[]) null);
                arr[0] = r;
                arr[1] = g;
                arr[2] = b;

                raster.setPixel(i, j, arr);
            }
        }

        icon = new ImageIcon(bi);
        return this;
    }

    public ImageIcon getImageIcon() {
        return icon;
    }

}
