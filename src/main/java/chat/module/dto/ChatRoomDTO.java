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

    private String createdAt;

    private List<ParticipantDTO> participants;

}
