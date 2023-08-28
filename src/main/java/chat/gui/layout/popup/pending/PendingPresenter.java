package chat.gui.layout.popup.pending;

import chat.gui.components.alert.Alert;
import chat.gui.components.alert.AlertType;
import chat.gui.layout.popup.pending.view.UserItem;
import chat.module.Storage;
import chat.module.dto.UserDTO;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PendingPresenter {

    private final PendingModel model;
    private final PendingView view;

    public PendingPresenter(PendingModel model, PendingView view) {
        this.model = model;
        this.view = view;

        init();
    }

    private void init() {

    }

    public void addFriend(UserDTO userDTO) {
        Long no = ((UserDTO) Storage.getInstance().getData(Storage.LOGIN_USER)).getNo();

        model.save(no, userDTO.getNo());

        Alert.createAlert(AlertType.SUCCESS, "친추 성공", "친구 추가 완료");

        view.initResultPanel();
    }

    public void search() {
        String keyword = view.getKeyword();

        if(keyword.isEmpty()) {
            Alert.createAlert(AlertType.ERROR, "입력 올퓨", "입력 플리즈");;
            return;
        }

        Long userNo = ((UserDTO) Storage.getInstance().getData(Storage.LOGIN_USER)).getNo();

        List<UserDTO> list = model.selectNotFriendUserList(keyword, userNo);
        List<UserItem> userItemList = new ArrayList<>();

        ButtonGroup group = new ButtonGroup();
        for(UserDTO userDTO : list) {
            UserItem item = new UserItem(userDTO);
            item.addClickFriendAddButton(e -> addFriend(userDTO));
            group.add(item.getRadio());

            userItemList.add(item);
        }

        if(list.size() == 0) {
            Alert.createAlert(AlertType.ERROR, "검색 ㅇㄹ", "검색 결과 없음");
            view.initResultPanel();
            return;
        }

        view.addResultList(userItemList);
    }

}
