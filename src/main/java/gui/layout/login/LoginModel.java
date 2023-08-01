package gui.layout.login;

import gui.mvc.Model;
import module.RetrofitFactory;
import module.RetrofitUtils;
import module.dto.UserDTO;

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

        UserDTO userDTO = RetrofitUtils.getCallBody(service.login(getId(), getPassword()));

        return userDTO;
    }
}
