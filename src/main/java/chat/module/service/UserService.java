package chat.module.service;

import chat.module.dto.UserDTO;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface UserService {

    @GET("/api/user/account")
    Call<UserDTO> login(
            @Query("id") String id,
            @Query("password") String password
    );

    @POST("/api/user/account")
    Call<Long> createAccount(
            @Body UserDTO userDTO
    );

    @PUT("/api/user/account")
    Call<Long> updateAccount(
            @Body UserDTO userDTO
    );

    @GET("/api/user/check/id")
    Call<Boolean> checkIsSaveSameID(
            @Query("id") String id
    );

    @Multipart
    @POST("/api/user/image")
    Call<String> uploadImage(
            @Part MultipartBody.Part image,
            @Part("id") RequestBody id
    );

}
