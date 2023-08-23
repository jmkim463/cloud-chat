package chat.module.service;

import chat.module.dto.ChatRoomDTO;
import chat.module.dto.MessageDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface ChatService {

    @GET("/api/chat/user/chatroom")
    public Call<List<ChatRoomDTO>> selectUserChatRoomList(
            @Query("userNo") Long userNo
    );

    @GET("/api/chat/chatroom/massage")
    public Call<List<MessageDTO>> selectChatRoomOfMessage(
            @Query("chatroomNo") Long chatroomNo
    );

}
