package gui.layout.login;

import gui.mvc.Model;
import module.retrofit.RetrofitUtils;
import module.dto.UserDTO;
import module.service.UserService;

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
        UserService service = RetrofitFactory.createService(UserService.class);

        UserDTO userDTO = RetrofitUtils.getCallBody(service.login(getId(), getPassword()));

        return userDTO;
    }
}
