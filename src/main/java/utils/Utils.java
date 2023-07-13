package utils;

import javax.swing.*;
import java.awt.*;

public class Utils {

    public static JPanel coverComponentsFlowlayout(Component...components) {
        JPanel panel = new JPanel(new FlowLayout());

        for(Component component : components) {
            panel.add(component);
        }

        return panel;
    }
}
