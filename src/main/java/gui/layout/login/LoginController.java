package gui.layout.login;

import gui.alert.Alert;
import gui.alert.AlertType;
import gui.components.EventObserver;
import gui.layout.chat.ChatController;
import gui.layout.login.view.LoginView;
import gui.mvc.Controller;
import gui.mvc.Model;
import gui.mvc.View;
import module.RetrofitUtils;
import module.Storage;
import module.dto.UserDTO;
import module.service.UserService;
import retrofit2.Call;
import retrofit2.Response;

import java.net.http.HttpRequest;
import java.util.Map;
import java.util.Random;

public class LoginController implements Controller {

    private static UserService service;

    private LoginView view = new LoginView();
    private LoginModel model = new LoginModel();

    static {
        service = RetrofitUtils.createService(UserService.class);
    }

    public LoginController() {
        init();
    }

    private void init() {

        view.setClickLoginListener(new ClickLoginListener());

    }

    static Map<String, Object> login(String id, String password) {
        Response<UserDTO> response = RetrofitUtils.execute(service.login(id, password));

        if(response.code() != 200) {
            return null;   
        }


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

            if(id.isEmpty() || password.isEmpty()) {
                Alert.createAlert(AlertType.ERROR, "로그인 실패", "아아디, 비밀번호를 입력해주세요.");
                return;
            }



            if(userDTO == null) {
                Alert.createAlert(AlertType.ERROR, "로그인 실패", "존재하지 않는 아이디 또는 잘못된 비밀번호 입니다.");
                return;
            }

            Storage.getInstance().addAttribute("loginUserDTO", userDTO);

            view.close();

            Controller controller = new ChatController();
            controller.getView().open();
        }

    }

}
