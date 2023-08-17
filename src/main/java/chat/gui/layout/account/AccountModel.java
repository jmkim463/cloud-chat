package chat.gui.layout.account;

import chat.module.RetrofitUtils;
import chat.module.service.UserService;
import retrofit2.Call;
import retrofit2.Response;

import java.util.regex.Pattern;

public class AccountModel {

    private final UserService service;

    public AccountModel() {
        service = RetrofitUtils.createService(UserService.class);
    }

    public boolean isHaveSameID(String id) {
        if(!isCorrectIDPattern(id)) {
            return false;
        }

        boolean is = RetrofitUtils.getCallBody(service.checkIsSaveSameID(id));

        return is;
    }

    public boolean isCorrectIDPattern(String id) {
        if(id.isEmpty()) {
            return false;
        }

        if (!id.matches("^(?=.*[a-zA-Z])[a-zA-Z\\d]{5,25}$")) {
            return false;
        }

        return true;
    }

    public boolean isCorrectPasswordPattern(String password) {
        return false;
    }

}
