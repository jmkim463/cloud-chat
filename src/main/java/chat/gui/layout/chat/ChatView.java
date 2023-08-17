package chat.gui.layout.chat;

import chat.gui.layout.chat.view.ChatField;
import chat.gui.layout.chat.view.ChatRoomList;
import chat.gui.components.Panel;
import chat.module.dto.MessageDTO;

import java.awt.*;

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
    }

    public String getMessage() {
        return chatField.getMessage();
    }

}
