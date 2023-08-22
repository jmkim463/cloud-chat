package chat.module.service;

import chat.module.dto.ChatRoomDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface ChatService {

    @GET("/api/chat/user/chatroom")
    public Call<List<ChatRoomDTO>> selectUserChatRoomList(
            @Query("userNo") Long userNo
    );

}
