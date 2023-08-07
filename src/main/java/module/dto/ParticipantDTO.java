package module.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParticipantDTO {

    private String no;
    private String userNo;
    private String chatRoomNo;
    private String joinAt;

}
