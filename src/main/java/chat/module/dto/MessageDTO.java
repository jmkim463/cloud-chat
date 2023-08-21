package chat.module.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageDTO {

    private Long no;
    private Long chatroomNo;
    private UserDTO senderDTO;
    private String content;
    private String sendAt;

}
