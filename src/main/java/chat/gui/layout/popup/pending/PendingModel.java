package chat.gui.layout.popup.pending;

import chat.module.RetrofitUtils;
import chat.module.dto.FriendDTO;
import chat.module.dto.UserDTO;
import chat.module.service.FriendService;

import java.util.List;

public class PendingModel {

    private final FriendService service;

    public PendingModel() {
        service = RetrofitUtils.createService(FriendService.class);
    }

    public List<UserDTO> selectNotFriendUserList(String keyword, Long userNo) {
        List<UserDTO> list = RetrofitUtils.getCallBody(service.getNotFriendUser(keyword, userNo));

        return list;
    }

    public Long save(Long userNo1, Long userNo2) {
        FriendDTO friendDTO = FriendDTO.builder()
                .userNo1(userNo1)
                .userNo2(userNo2)
                .build();

        Long no = RetrofitUtils.getCallBody(service.save(friendDTO));

        return no;
    }
}
