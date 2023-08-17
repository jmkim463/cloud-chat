package chat.gui.layout.account;

import chat.gui.components.Panel;
import chat.gui.layout.account.view.AccountField;
import chat.gui.layout.account.view.UserImage;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AccountView extends Panel {

    private final AccountField field;
    private final UserImage image;

    private boolean isHaveSameIDCheck = false;

    public AccountView() {
        field = new AccountField();
        image = new UserImage();

        init();
    }

    private void init() {
        setLayout(new BorderLayout());

        add(image, BorderLayout.NORTH);
        add(field);

        field.getID().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                setHaveSameIDCheck(false);
            }
        });

        cover();
    }

    public void addCancelButtonClickListener(ActionListener actionListener) {
        field.getCancelButton().setClickEvent(actionListener);
    }

    public void addSameIDCheckClickListener(ActionListener actionListener) {
        field.getSameIDCheckButton().setClickEvent(actionListener);
    }

    public void setHaveSameIDCheck(boolean haveSameIDCheck) {
        isHaveSameIDCheck = haveSameIDCheck;
    }

    public boolean isHaveSameIDCheck() {
        return isHaveSameIDCheck;
    }

    public String getID() {
        return field.getID().getText();
    }

    public String getPassword() {
        return field.getPassword().getText();
    }

    public String getPasswordCheck() {
        return field.getPasswordCheck().getText();
    }

    public String getName() {
        return field.getNameField().getName();
    }

    public String getEmail() {
        return field.getEmail().getText();
    }

    public String getDomain() {
        return field.getDomain().getSelectedItem() + "";
    }
}
