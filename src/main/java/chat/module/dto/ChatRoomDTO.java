package chat.module.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChatRoomDTO {

    private Long no;
    private String name;
    private String createAt;

    private String userNameList;
    private String userIdList;
    private String lastChat;
    private String lastAt;
    private List<Long> participants;

}
