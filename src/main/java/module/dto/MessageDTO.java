package module.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageDTO {

    private String no;
    private String roomNo;
    private String senderUserNo;
    private String content;
    private String sendAt;

}
