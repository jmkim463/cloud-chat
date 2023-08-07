package gui.layout.login;

import gui.mvc.Model;
import module.RetrofitUtils;
import module.dto.UserDTO;
import module.service.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginModel implements Model {

    public UserDTO login(String id, String password) {
        UserService service = RetrofitUtils.createService(UserService.class);

        UserDTO userDTO = RetrofitUtils.getCallBody(service.login(id, password));

        return userDTO;
    }
}
