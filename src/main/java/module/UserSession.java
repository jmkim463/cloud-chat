package module;

import gui.utils.ImageUtils;
import module.dto.UserDTO;

import javax.swing.*;
import java.net.URL;

public class UserSession {

    private static UserSession instance;

    private int no;
    private String name;
    private String email;
    private String imageURL;
    private ImageIcon image;

    public static UserSession getInstance() {
        if(instance == null) {
            instance = new UserSession();
        }

        return instance;
    }

    public static void logout() {
        instance = null;
    }

    public void setUserSession(UserDTO userDTO) {
        this.no = userDTO.getNo();
        this.name = userDTO.getName();
        this.imageURL = userDTO.getImageURL();
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public ImageIcon getImage() {
        if(image == null) {
            try {
                image = new ImageIcon(new URL(imageURL));
            } catch (Exception e) {
                image = ImageUtils.getDefaultUserImageIcon();
            }
        }
        return image;
    }
}
