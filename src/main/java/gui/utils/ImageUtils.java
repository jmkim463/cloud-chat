package gui.utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageUtils {

    private final static ImageIcon DEFAULT_USER_IMAGE_ICON = new ImageIcon(ImageUtils.getURL("default_user.png"));
    private final static ImageIcon MAIN_IMAGE_ICON = new ImageIcon(getURL("cloud.png"));

    public static ImageIcon getDefaultUserImageIcon() {
        return DEFAULT_USER_IMAGE_ICON;
    }

    public static ImageIcon getMainImageIcon() {
        return MAIN_IMAGE_ICON;
    }

    public static ImageIcon changePNGImageColor(String fileName, Color color) {
        try {
            BufferedImage bi = ImageIO.read(new File(getURL(fileName)));
            WritableRaster raster = bi.getRaster();

            for(int i = 0; i < bi.getWidth(); i++) {
                for(int j = 0; j < bi.getHeight(); j++) {
                    int[] arr = raster.getPixel(i, j, (int[]) null);

                    arr[0] = color.getRed();
                    arr[1] = color.getGreen();
                    arr[2] = color.getBlue();

                    raster.setPixel(i, j, arr);
                }
            }

            return new ImageIcon(bi);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ImageIcon setImageIconSize(int width, int height, ImageIcon icon) {
        return new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    public static String getURL(String fileName) {
        try {
            return ImageUtils.class.getClassLoader().getResource(fileName).getPath();
        } catch (Exception e) {
            return null;
        }
    }

    public static ImageIcon changeToCircleImage(int size, ImageIcon icon) {
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

        return new ImageIcon(bi2);
    }

    public static byte[] imageIconToByteArray(ImageIcon icon) {
        BufferedImage bi = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_BGR);
        Graphics2D g2 = bi.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        icon.paintIcon(null, g2, 0, 0);
        g2.dispose();

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        return null;
    }

    public static ImageIcon getURLImageIcon(String url) {
        try {
            return new ImageIcon(new URL(url));
        } catch (MalformedURLException e) {
            return null;
        }
    }
}
