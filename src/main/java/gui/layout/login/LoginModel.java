package gui.layout.login;

import gui.mvc.Model;
import lombok.extern.slf4j.Slf4j;
import module.RetrofitFactory;
import module.dto.UserDTO;
import module.service.LoginService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginModel implements Model {

    private String id;
    private String password;

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public UserDTO login() {
        LoginService service = RetrofitFactory.createService(LoginService.class);

        UserDTO userDTO = null;
        try {
            userDTO = service.login(getId(), getPassword()).execute().body();
        } catch (Exception e) {

        }

        return userDTO;
    }
}
