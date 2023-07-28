package gui.layout.login;

import gui.alert.Alert;
import gui.alert.AlertType;
import gui.components.Frame;
import gui.layout.account.AccountController;
import gui.layout.chatting.ChatController;
import gui.layout.login.view.LoginField;
import gui.layout.login.view.LoginView;
import gui.mvc.Controller;
import gui.mvc.Model;
import gui.mvc.View;
import module.dto.UserDTO;

import javax.naming.ldap.Control;

public class LoginController implements Controller {

    private LoginView view = new LoginView();
    private LoginModel model = new LoginModel();

    public static void main(String[] args) {
        LoginController controller = new LoginController();
        controller.getView().open();
    }

    public LoginController() {
        init();
    }

    private void init() {
        view.setLoginLogic(this::login);
        view.setAccountLogic(this::account);
    }

    public void login() {
        model.setId(view.getID());
        model.setPassword(view.getPassword());

        UserDTO userDTO = model.login();


        if(userDTO == null) {
            Alert.createAlert(AlertType.ERROR, "로그인 실패", "존재하지 않는 아이디 또는 잘못된 비밀번호 입니다.");
            return;
        }
        System.out.println(userDTO.getName());

        //TODO 로그인 회원 정보 저장 로직

        view.close();

        Controller controller = new ChatController();
        controller.getView().open();
    }

    public void account() {
        Controller controller = new AccountController();
        controller.getView().open();
    }

    @Override
    public Model getModel() {
        return model;
    }

    @Override
    public View getView() {
        return view;
    }
}
