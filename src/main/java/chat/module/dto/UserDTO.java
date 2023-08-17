package chat.module.dto;

import chat.module.RetrofitUtils;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    private String no;
    private String name;
    private String id;
    private String password;
    private String email;

    public String getImageURL() {
        return RetrofitUtils.getBaseUrl() + "/api/images/display?filename=" + getId() + ".jpg&type=user";
    }
}
