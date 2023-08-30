package chat.module.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageDTO {

    private Long no;
    private Long chatroomNo;
    private UserDTO senderDTO;
    private Long senderNo;
    private String content;
    private String sendAt;

    public static String getNowDateTime() {
        return new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").format(new Date());
    }

}
