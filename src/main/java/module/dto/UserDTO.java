package module.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    private int no;
    private String name;
    private String id;
    private String password;
    private String email;
}
