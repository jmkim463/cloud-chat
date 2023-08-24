package chat.gui.layout.popup.account;


import chat.gui.components.alert.Alert;
import chat.gui.components.alert.AlertType;

import java.io.File;

public class AccountPresenter {

    private final AccountModel model;
    private final AccountView view;

    public AccountPresenter(AccountModel model, AccountView view) {
        this.model = model;
        this.view = view;
    }

    public void clickSameUsernameCheckButton() {
        String username = view.getID();

        boolean isHaveSameUsername = model.isHaveSameUsername(username);

        if(isHaveSameUsername) {
            Alert.createAlert(AlertType.SUCCESS, "성공", "중복아님");
        } else {
            Alert.createAlert(AlertType.ERROR, "실패", "중복임");
        }

        view.setHaveSameIDCheck(isHaveSameUsername);
    }

    public void clickAccountButton() {
        String id = view.getID();
        String password = view.getPassword();
        String passwordCheck = view.getPasswordCheck();
        String name = view.getUsername();
        String email = view.getEmail();
        String domain = view.getDomain();

        String imageFilePath = view.getImageFilePath();

        boolean isCheckHaveSameID = view.isHaveSameIDCheck();

        if(!model.isCorrectIDPattern(id)) {
            Alert.createAlert(AlertType.ERROR, "회원가입 실패", "아이디 형식");
            return;
        }

        if(!isCheckHaveSameID) {
            Alert.createAlert(AlertType.ERROR, "회원가입 실패", "아이디 중복 체크");
            return;
        }

        if(!model.isCorrectPasswordPattern(password)) {
            Alert.createAlert(AlertType.ERROR, "회원가입 실패", "비밀번호 형식");
            return;
        }

        if(!password.equals(passwordCheck)) {
            Alert.createAlert(AlertType.ERROR, "회원가입 실패", "비밀번호 불일치");
            return;
        }

        if(imageFilePath == null) {
            Alert.createAlert(AlertType.ERROR, "회원가입 실패", "이미지 미 추가");
            return;
        }

        System.out.println(imageFilePath);
        model.createAccount(id, password, name, email + "@" + domain, new File(imageFilePath));

        Alert.createAlert(AlertType.SUCCESS, "회원가입 성공", "완료");
    }

}
