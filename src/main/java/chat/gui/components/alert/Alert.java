package chat.gui.components.alert;

import chat.gui.components.LabelBuilder;
import chat.gui.components.Modal;
import chat.gui.components.Panel;

import javax.swing.*;

public class Alert {

    public static void createAlert(AlertType type, String title, String text) {
        Panel panel = new Panel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(panel.cover(new LabelBuilder(type.getIcon()).getLabel()));
        panel.add(panel.cover(new LabelBuilder(title).setFont(35).getLabel()));
        panel.add(panel.cover(new LabelBuilder(text).getLabel()));

        Modal modal = new Modal(370, 220);
        modal.add(panel);
        modal.setVisible(true);
    }

}
