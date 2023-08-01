package gui.components;

import gui.utils.Colors;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;

public class ComboBox<T> extends JComboBox {

    public ComboBox() {
        init();
    }

    private void init() {
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Colors.getBorderLineColor()));
        setFont(new Font(13));

        setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                return new ArrowButton();
            }
        });
        setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                return new LabelBuilder(value + "").setFont(13).getLabel();
            }
        });
    }

    public void addItems(T...t) {
        for(T item : t) {
            addItem(item);
        }
    }

    class ArrowButton extends JButton {
        public ArrowButton() {
            init();
        }

        private void init() {
            setText("▼");
            setFont(new Font());
            setForeground(Color.lightGray);
            setFocusPainted(false);
            setBorder(null);
            setContentAreaFilled(false);
        }
    }

}
