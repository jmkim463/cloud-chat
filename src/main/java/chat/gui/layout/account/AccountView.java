package chat.gui.layout.account;

import chat.gui.components.Panel;
import chat.gui.layout.account.view.AccountField;
import chat.gui.layout.account.view.UserImage;

import java.awt.*;
import java.awt.event.ActionListener;

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

        add(new UserImage(), BorderLayout.NORTH);
        add(new AccountField());

        cover();
    }

    public void addSameIDCheckClickListener(ActionListener actionListener) {
        field.getSameIDCheckButton().setClickEvent(actionListener);
    }

    public void setHaveSameIDCheck(boolean haveSameIDCheck) {
        isHaveSameIDCheck = haveSameIDCheck;
    }

    public String getID() {
        return field.getID();
    }

}
