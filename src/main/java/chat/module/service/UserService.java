package chat.module.service;

import chat.module.dto.UserDTO;
import retrofit2.Call;
import retrofit2.http.*;

public interface UserService {

    @GET("/api/user/login")
    Call<UserDTO> login(
            @Query("id") String id,
            @Query("password") String password
    );

    @GET("/api/user/check/{id}")
    Call<Boolean> checkID(
            @Path("id") String id
    );

    @POST("/api/user/account")
    void account(
            @Body UserDTO userDTO
    );
}
