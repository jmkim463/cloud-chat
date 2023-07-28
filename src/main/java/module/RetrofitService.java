package module;

import module.dto.UserDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {



    @POST("/api/user/account")
    Call<UserDTO> account(

    );
}
