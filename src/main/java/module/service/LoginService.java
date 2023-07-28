package module.service;

import module.dto.UserDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LoginService {

    @GET("/api/user/login")
    Call<UserDTO> login(
            @Query("id") String id,
            @Query("password") String password
    );

}
