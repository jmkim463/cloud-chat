package gui.layout.login;

import gui.alert.Alert;
import gui.alert.AlertType;
import gui.components.EventObserver;
import gui.layout.chat.ChatController;
import gui.layout.login.view.LoginView;
import gui.mvc.Controller;
import gui.mvc.Model;
import gui.mvc.View;
import module.Storage;
import module.dto.UserDTO;

import java.util.Map;
import java.util.Random;

public class LoginController implements Controller {

    private LoginView view = new LoginView();
    private LoginModel model = new LoginModel();

    public LoginController() {
        init();
    }

    private void init() {

        view.setClickLoginListener(new ClickLoginListener());

    }

    @Override
    public Model getModel() {
        return model;
    }

    @Override
    public View getView() {
        return view;
    }

    class ClickLoginListener extends EventObserver {

        @Override
        public void execute(Map<String, Object> paramMap) {
            String id = (String) paramMap.get("id");
            String password = (String) paramMap.get("password");

            UserDTO userDTO = model.login(id, password);

            if(userDTO == null) {
                Alert.createAlert(AlertType.ERROR, "로그인 실패", "존재하지 않는 아이디 또는 잘못된 비밀번호 입니다.");
                return;
            }

            userDTO.setNo("USER-" + new Random().nextInt());
            Storage.getInstance().addAttribute("userDTO", userDTO);

            view.close();

            Controller controller = new ChatController();
            controller.getView().open();
        }

    }

}
