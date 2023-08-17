package chat.gui.layout.account;


import chat.gui.alert.Alert;
import chat.gui.alert.AlertType;

public class AccountPresenter {

    private final AccountModel model;
    private final AccountView view;

    public AccountPresenter(AccountModel model, AccountView view) {
        this.model = model;
        this.view = view;
    }

    public void clickIsHaveSameIDButton() {
        String id = view.getID();

        boolean isHaveSameID = model.isHaveSameID(id);

        if(isHaveSameID) {
            Alert.createAlert(AlertType.SUCCESS, "성공", "중복아님");
        } else {
            Alert.createAlert(AlertType.ERROR, "실패", "중복임");
        }

        view.setHaveSameIDCheck(isHaveSameID);
    }

    public void clickAccountButton() {
        String id = view.getID();
        String password = view.getPassword();
        String passwordCheck = view.getPasswordCheck();
        String name = view.getName();
        String email = view.getEmail();
        String domain = view.getDomain();

        boolean isCheckHaveSameID = view.isHaveSameIDCheck();

        if(!model.isCorrectIDPattern(id)) {

        }

        if(!isCheckHaveSameID) {

        }

        if(!model.isCorrectPasswordPattern(password)) {

        }

        if(!password.equals(passwordCheck)) {

        }
        
    }

}
