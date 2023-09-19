package chat.module.service;

import chat.module.dto.ChatRoomDTO;
import chat.module.dto.MessageDTO;
import chat.module.dto.UserDTO;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ChatService {

    @GET("/api/chat/chatroom/{userNo}")
    Call<List<ChatRoomDTO>> selectUserChatRoomList(
            @Path("userNo") Long userNo
    );

    @GET("/api/chat/chatroom")
    Call<ChatRoomDTO> selectPrivateChatRoom(
            @Query("userNo1") Long userNo1,
            @Query("userNo2") Long userNo2
    );

    @GET("/api/chat/massage")
    Call<List<MessageDTO>> selectChatRoomOfMessage(
            @Query("chatroomNo") Long chatroomNo
    );

    @Multipart
    @POST("/api/chat/image")
    Call<String> uploadImage(
            @Part MultipartBody.Part image
    );

    @POST("/api/chat/chatroom")
    Call<String> saveGroupChatRoom(
            @Body ChatRoomDTO chatRoomDTO
    );

}
