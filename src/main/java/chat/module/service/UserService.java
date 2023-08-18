package chat.module.service;

import chat.module.dto.UserDTO;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface UserService {

    @GET("/api/user/login")
    Call<UserDTO> login(
            @Query("id") String id,
            @Query("password") String password
    );

    @GET("/api/user/check/id")
    Call<Boolean> checkIsSaveSameID(
            @Query("id") String id
    );

    @POST("/api/user/account")
    Call<Long> createAccount(
            @Body UserDTO userDTO
    );

    @Multipart
    @POST("/api/image/upload")
    Call<Integer> uploadAccountImage(
            @Part MultipartBody.Part image,
            @Part("filename") RequestBody filename,
            @Part("type") RequestBody type
    );

}
