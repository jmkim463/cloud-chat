package chat.gui.layout.popup.account;

import chat.module.RetrofitUtils;
import chat.module.dto.UserDTO;
import chat.module.service.UserService;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;

import java.io.File;
import java.util.regex.Pattern;

public class AccountModel {

    private final UserService service;

    private UserDTO oldUserDTO;

    public AccountModel() {
        service = RetrofitUtils.createService(UserService.class);
    }

    public boolean isHaveSameUsername(String id) {
        boolean is = RetrofitUtils.getCallBody(service.checkIsSaveSameID(id));
        return is;
    }

    public boolean isCorrectIDPattern(String id) {
        return id.matches("^(?=.*[a-zA-Z])[a-zA-Z\\d]{5,25}$");
    }

    public boolean isCorrectPasswordPattern(String password) {
        return password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*]).{5,50}$");
    }

    public Long createAccount(String id, String password, String name, String email, File file) {
        UserDTO userDTO = UserDTO.builder()
                .id(id)
                .password(password)
                .name(name)
                .email(email).build();

        Long no = RetrofitUtils.getCallBody(service.createAccount(userDTO));
        RetrofitUtils.execute(service.uploadImage(RetrofitUtils.imageToMultipartBody(file), RetrofitUtils.textToRequestBody(id)));

        return no;
    }

    public void updateAccount(String password, String name, String email, File file) {
        UserDTO userDTO = UserDTO.builder()
                .no(oldUserDTO.getNo())
                .id(oldUserDTO.getId())
                .password(password)
                .name(name)
                .email(email).build();

        service.updateAccount(userDTO);
        RetrofitUtils.execute(service.uploadImage(RetrofitUtils.imageToMultipartBody(file), RetrofitUtils.textToRequestBody(oldUserDTO.getId())));
    }

    public void setOldUserDTO(UserDTO oldUserDTO) {
        this.oldUserDTO = oldUserDTO;
    }

    public UserDTO getOldUserDTO() {
        return oldUserDTO;
    }
}
