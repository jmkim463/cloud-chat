package gui.layout.chatting;

import gui.layout.chatting.view.ChatView;
import gui.mvc.Controller;
import gui.mvc.Model;
import gui.mvc.View;
import module.retrofit.RetrofitUtils;
import module.session.UserSession;
import module.dto.ChatRoomDTO;
import module.service.ChatService;

import java.util.List;

public class ChatController implements Controller {

    private ChatView view = new ChatView();
    private ChatModel model = new ChatModel();

    public ChatController() {
        init();
    }

    private void init() {
        ChatService service = RetrofitFactory.createService(ChatService.class);

        List<ChatRoomDTO> list = RetrofitUtils.getCallBody(service.getUserRoomListAll(UserSession.getInstance().getNo()));

        view.setAllChatRoomList(list);
    }



    @Override
    public Model getModel() {
        return model;
    }

    @Override
    public View getView() {
        return view;
    }
}
