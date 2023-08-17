package chat.module.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageDTO {

    private String no;
    private String chatRoomNo;
    private UserDTO senderUserDTO;
    private String content;
    private String sendAt;

}
