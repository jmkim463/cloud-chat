package chat.module.service;

import chat.module.dto.FriendDTO;
import chat.module.dto.UserDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;

public interface FriendService {

    @GET("/api/friend/list")
    Call<List<UserDTO>> getFriendList(
            @Query("userNo") Long userNo
    );

    @GET("/api/friend/list/pending")
    Call<List<UserDTO>> getPendingFriendList(
            @Query("userNo") Long userNo
    );

    @GET("/api/friend/list/not")
    Call<List<UserDTO>> getNotFriendUser(
        @Query("keyword") String keyword,
        @Query("userNo") Long userNo
    );

    @POST("/api/friend/save")
    Call<Long> save(
        @Body FriendDTO friendDTO
    );

}
