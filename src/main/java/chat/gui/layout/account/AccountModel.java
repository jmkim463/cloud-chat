package chat.gui.layout.account;

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

    public int createAccount(String id, String password, String name, String email, File file) {
        UserDTO userDTO = UserDTO.builder()
                .id(id)
                .password(password)
                .name(name)
                .email(email).build();

        Long no = RetrofitUtils.getCallBody(service.createAccount(userDTO));

        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part image = MultipartBody.Part.createFormData("file", file.getName(), requestBody);

        RequestBody filenameRequestBody = RequestBody.create(MediaType.parse("text/plain"), id + "_" + no + ".jpg");
        RequestBody typeRequestBody = RequestBody.create(MediaType.parse("text/plain"), "user");

        service.uploadAccountImage(image, filenameRequestBody, typeRequestBody);

        return 200;
    }
}
