package gui.layout.login;

import gui.mvc.Model;
import module.retrofit.RetrofitUtils;
import module.dto.UserDTO;
import module.service.UserService;

public class LoginModel implements Model {

    public UserDTO login(String id, String password) {
        UserService service = RetrofitUtils.createService(UserService.class);

        UserDTO userDTO = RetrofitUtils.getCallBody(service.login(id, password));

        return userDTO;
    }
}
