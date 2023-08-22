package chat.module.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParticipantDTO {

    private Long no;
    private Long userNo;
    private Long chatRoomNo;
    private String joinAt;

}
