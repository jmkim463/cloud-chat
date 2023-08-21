package chat.module.dto;

import chat.module.RetrofitUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private Long no;
    private String name;
    private String id;
    private String password;
    private String email;

    public String getImageURL() {
        return RetrofitUtils.getBaseUrl() + "/api/image/display?filename=" + getId().hashCode() + ".jpg&type=user";
    }

}
