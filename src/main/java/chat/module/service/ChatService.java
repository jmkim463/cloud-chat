package chat.module.service;

import chat.module.dto.ChatRoomDTO;
import chat.module.dto.MessageDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface ChatService {

    @GET("/api/chat/user/chatroom")
    Call<List<ChatRoomDTO>> selectUserChatRoomList(
            @Query("userNo") Long userNo
    );

    @GET("/api/chat/chatroom/massage")
    Call<List<MessageDTO>> selectChatRoomOfMessage(
            @Query("chatroomNo") Long chatroomNo
    );

    @GET("/api/chat/chatroom")
    Call<ChatRoomDTO> selectPrivateChatRoom(
            @Query("userNo1") Long userNo1,
            @Query("userNo2") Long userNo2
    );
}
