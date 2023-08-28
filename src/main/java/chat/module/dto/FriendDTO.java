package chat.module.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FriendDTO {

    private Long no;
    private Long userNo1;
    private Long userNo2;
    private int state;

}
