package chat.gui.layout.popup.group;

import chat.gui.components.Modal;
import chat.gui.components.alert.Alert;
import chat.gui.components.alert.AlertType;
import chat.gui.layout.popup.group.view.UserItem;
import chat.module.Storage;
import chat.module.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class GroupPresenter {

    private final GroupModel model;
    private final GroupView view;
    private final Modal modal;

    public GroupPresenter(GroupModel model, GroupView view, Modal modal) {
        this.model = model;
        this.view = view;
        this.modal = modal;

        init();
    }

    private void init() {
        setFriendList();
    }

    public void setFriendList() {
        List<UserItem> list = new ArrayList<>();

        for(UserDTO dto : model.getFriendList()) {
            UserItem item = new UserItem(dto);
            list.add(item);
        }

        view.setFriendList(list);
    }

    public void clickSaveButtonListener() {
        String name = view.getGroupName();
        List<Long> list = view.getSelectedList();

        if(name.isEmpty()) {
            Alert.createAlert(AlertType.ERROR, "생성 실패", "그룹 방 이름을 입력하시오.");
            return;
        }

        if(list.size() < 2) {
            Alert.createAlert(AlertType.ERROR, "생성 실패", "2명 이상의 인원이 필요합니다.");
            return;
        }

        list.add(((UserDTO) Storage.getInstance().getData(Storage.LOGIN_USER)).getNo());

        model.save(name, list);

        Alert.createAlert(AlertType.SUCCESS, "생성 완료", "그룹 챗팅 방이 성공적으로 완성되었습니다.");
        modal.dispose();
    }
}
