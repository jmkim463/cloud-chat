package chat.gui.layout.chat;

import chat.gui.components.button.Button;
import chat.gui.layout.chat.view.ChatField;
import chat.gui.layout.chat.view.ChatRoom;
import chat.gui.layout.chat.view.ChatRoomList;
import chat.gui.components.Panel;
import chat.module.dto.ChatRoomDTO;
import chat.module.dto.MessageDTO;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class ChatView extends Panel {

    private final ChatRoomList chatRoomList;
    private final ChatField chatField;

    public ChatView() {
        chatRoomList = new ChatRoomList();
        chatField = new ChatField();

        init();
    }

    private void init() {
        setLayout(new BorderLayout());

        add(chatRoomList, BorderLayout.WEST);
        add(chatField);
    }

    public void addMessage(MessageDTO messageDTO) {
        chatField.addMessage(messageDTO);
        chatField.scrollToBottom();
        chatField.initInputField();

        chatField.revalidate();
        chatField.repaint();
    }

    public void refreshChatRoomList(List<ChatRoomDTO> chatRoomDTOList) {
        chatRoomList.setChatRoomList(chatRoomDTOList);
    }

    public String getMessage() {
        return chatField.getMessage();
    }

    public void addSendMessageListener(ActionListener actionListener) {
        chatField.getMessageSendButton().setClickEvent(actionListener);
    }
}
