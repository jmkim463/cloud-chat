package module.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ChatRoomDTO {

    private String no;
    private String createdAt;
    private List<ParticipantDTO> participants;

}
