package chat.gui.layout.chat;

import chat.gui.layout.chat.view.ChatRoom;
import chat.module.Storage;
import chat.module.dto.ChatRoomDTO;
import chat.module.dto.UserDTO;
import com.google.gson.Gson;
import chat.module.SocketManager;
import chat.module.dto.MessageDTO;

import java.util.ArrayList;
import java.util.List;

public class ChatPresenter {

    private final ChatView view;
    private final ChatModel model;

    private final Gson gson;

    public ChatPresenter(ChatModel model, ChatView view) {
        this.model = model;
        this.view = view;
        this.gson = new Gson();

        init();
    }

    private void init() {

    }

    public void refreshChatRoomList() {
        List<ChatRoomDTO> list = model.getUserChatRoomList();

        List<ChatRoom> chatRooms = new ArrayList<>();
        for(ChatRoomDTO item : list) {
            ChatRoom chatroom = new ChatRoom(item);
            chatroom.setClick(e -> selectChatRoom(chatroom));

            chatRooms.add(chatroom);
        }

        if(chatRooms.size() != 0) {
            selectChatRoom(chatRooms.get(0));
            view.refreshChatRoomList(chatRooms);
        }
    }

    public void selectChatRoom(ChatRoom chatroom) {
        if(view.getSelectedChatRoom() != null) {
            view.getSelectedChatRoom().setSelected(false);
        }
        view.setSelectedChatRoom(chatroom);
        view.getSelectedChatRoom().setSelected(true);

        refreshChatFieldMessage();
    }

    public void refreshChatFieldMessage() {
        Long chatroomNo = view.getSelectedChatRoom().getChatroomDTO().getNo();
        List<MessageDTO> list = model.getChatRoomOfMessageList(chatroomNo);

        view.refreshChatField(list);
    }

    public void clickMessageSendButton() {
        String content = view.getMessage();

        UserDTO userDTO = (UserDTO) Storage.getInstance().getData(Storage.LOGIN_USER);
        ChatRoomDTO chatRoomDTO = view.getSelectedChatRoom().getChatroomDTO();

        MessageDTO messageDTO = MessageDTO.builder()
                .senderDTO(userDTO)
                .senderNo(userDTO.getNo())
                .chatroomNo(chatRoomDTO.getNo())
                .content(content).build();

        SocketManager manager = SocketManager.getInstance();
        manager.sendMessage("MESSAGE", messageDTO);

        view.addMessage(messageDTO);
    }

    public void receiveMessage(String text) {
        MessageDTO messageDTO = gson.fromJson(text, MessageDTO.class);

        ChatRoom curChatroom = view.getSelectedChatRoom();
        ChatRoomDTO curChatroomDTO = curChatroom.getChatroomDTO();

        if(messageDTO.getChatroomNo() == curChatroomDTO.getNo()) {
            view.addMessage(messageDTO);
        } else {

        }

    }

}
