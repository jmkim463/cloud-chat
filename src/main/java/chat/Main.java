package chat;

import chat.gui.layout.login.LoginApp;
import chat.gui.utils.Colors;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        UIManager.put("Button.font", new chat.gui.components.Font());
        UIManager.put("TextArea.font", new chat.gui.components.Font());
        UIManager.put("TextField.font", new chat.gui.components.Font());
        UIManager.put("TextField.border", BorderFactory.createMatteBorder(0, 0, 1, 0, Colors.getBorderLineColor()));
        UIManager.put("PasswordField.border", BorderFactory.createMatteBorder(0, 0, 1, 0, Colors.getBorderLineColor()));

        UIManager.put("Panel.background", Color.white);
        UIManager.put("ComboBox.background", Color.white);

        LoginApp app = new LoginApp();
        app.open();

    }
}
