package chat.module.service;

import chat.module.dto.UserDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface FriendService {

    @GET("/api/friend/list")
    Call<List<UserDTO>> getFriendList(
            @Query("status") int status,
            @Query("userNo") Long userNo
    );


}
