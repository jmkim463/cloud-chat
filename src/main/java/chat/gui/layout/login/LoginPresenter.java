package chat.gui.layout.login;

import chat.gui.alert.Alert;
import chat.gui.alert.AlertType;
import chat.gui.layout.chat.ChatApp;
import chat.module.Storage;
import chat.module.dto.UserDTO;

public class LoginPresenter {

    private final LoginModel model;
    private final LoginView view;

    public LoginPresenter(LoginModel model, LoginView view) {
        this.model = model;
        this.view = view;
    }

    public void clickLoginButton() {
        String id = view.getID();
        String password = view.getPassword();

        try {
            UserDTO user = model.login(id, password);

            Storage.getInstance().setData(Storage.LOGIN_USER, user);

            ChatApp app = new ChatApp();
            app.open();

        } catch (IllegalArgumentException e) {
            Alert.createAlert(AlertType.ERROR, "로그인 오류", "아이디 또는 비밀번호를 확인해주세요.");
        }
    }

}
