package module.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChatRoomDTO {

    private String no;
    private String createdAt;

}
