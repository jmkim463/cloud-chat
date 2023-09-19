package chat.gui.layout.popup.account;


import chat.gui.components.Modal;
import chat.gui.components.alert.Alert;
import chat.gui.components.alert.AlertType;
import chat.module.dto.UserDTO;

import java.io.File;

public class AccountPresenter {

    private final AccountModel model;
    private final AccountView view;

    private Modal modal;

    public AccountPresenter(AccountModel model, AccountView view) {
        this.model = model;
        this.view = view;
    }

    public void setModal(Modal modal) {
        this.modal = modal;
    }

    public void setAccount(UserDTO userDTO) {
        model.setOldUserDTO(userDTO);
        view.setAccount(userDTO);
    }

    public void clickSameUsernameCheckButton() {
        String username = view.getID();

        boolean isHaveSameUsername = model.isHaveSameUsername(username);

        if(isHaveSameUsername) {
            Alert.createAlert(AlertType.SUCCESS, "사용 가능", "사용 가능한 아이디 입니다.");
        } else {
            Alert.createAlert(AlertType.ERROR, "사용 불가", "현재 사용 중인 아이디 입니다.");
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

        if(model.getOldUserDTO() == null) {
            if(!model.isCorrectIDPattern(id)) {
                Alert.createAlert(AlertType.ERROR, "아이디 오류", "아이디는 영문, 숫자 4자 이상 16이하로 입력해주세요.");
                return;
            }

            if(!isCheckHaveSameID) {
                Alert.createAlert(AlertType.ERROR, "아이디 오류", "아이디 중복 체크를 해주세요.");
                return;
            }
        }

        if(!model.isCorrectPasswordPattern(password)) {
            Alert.createAlert(AlertType.ERROR, "비밀번호 오류", "비밀번호는 영문, 숫자, 특수문자를 포함한 5자 이상 50자 이하로 입력해주세요.");
            return;
        }

        if(!password.equals(passwordCheck)) {
            Alert.createAlert(AlertType.ERROR, "비밀번호 오류", "비밀번호 불일치 합니다.");
            return;
        }

        if(imageFilePath == null) {
            Alert.createAlert(AlertType.ERROR, "이미지 오류", "이미지가 선택되지 않았습니다.");
            return;
        }

        if(email.isEmpty()) {
            Alert.createAlert(AlertType.ERROR, "이메일 오류", "이메일을 입력해주세요");
            return;
        }

        if(model.getOldUserDTO() == null) {
            model.createAccount(id, password, name, email + "@" + domain, new File(imageFilePath));
        } else {
            model.updateAccount(password, name, email + "@" + domain, new File(imageFilePath));
        }

        Alert.createAlert(AlertType.SUCCESS, "회원가입 성공", name + "님의 회원가입이 완료되었습니다!");

        modal.dispose();
    }
}
