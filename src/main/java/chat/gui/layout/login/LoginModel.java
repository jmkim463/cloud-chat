package chat.gui.layout.login;

import chat.module.RetrofitUtils;
import chat.module.dto.UserDTO;
import chat.module.service.UserService;
import retrofit2.Response;

public class LoginModel {

    private final UserService service;

    public LoginModel() {
        service = RetrofitUtils.createService(UserService.class);
    }

    public UserDTO login(String id, String password) {
        Response<UserDTO> response = RetrofitUtils.execute(service.login(id, password));

        if(response == null) {
            throw new IllegalArgumentException("Wrong ID or Password");
        }

        UserDTO user = response.body();

        return user;
    }

}
