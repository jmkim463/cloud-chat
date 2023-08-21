package chat.module.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParticipantDTO {

    private String no;
    private String userNo;
    private String chatRoomNo;
    private String joinAt;

}
