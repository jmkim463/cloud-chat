package chat.gui.layout.account;


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

        } else {

        }

        view.setHaveSameIDCheck(isHaveSameID);
    }


}
