package chat.gui.layout.chat;

import chat.gui.layout.chat.view.ChatField;
import chat.gui.layout.chat.view.ChatRoom;
import chat.gui.layout.chat.view.ChatRoomList;
import chat.gui.components.Panel;
import chat.module.dto.MessageDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class ChatView extends Panel {

    private final ChatRoomList chatRoomList;
    private final ChatField chatField;

    private Map<Long, ChatRoom> chatRoomMap;
    private ChatRoom selectedChatRoom;

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
        SwingUtilities.invokeLater(() -> {
            chatField.addMessage(messageDTO);
            chatField.initInputField();

            chatField.revalidate();
            chatField.repaint();

            chatField.scrollToBottom();
        });
    }

    public void refreshChatField(List<MessageDTO> messageDTOList) {
        SwingUtilities.invokeLater(() -> {
            chatField.clearMessageScroll();

            for(MessageDTO item : messageDTOList) {
                chatField.addMessage(item);
            }

            chatField.scrollToBottom();
            chatField.initInputField();

            revalidate();
            repaint();
        });
    }

    public void refreshChatRoomList(List<ChatRoom> chatRooms) {
        chatRoomMap.clear();
        for(ChatRoom item : chatRooms) {
            chatRoomMap.put(item.getChatroomDTO().getNo(), item);
        }

        chatRoomList.refreshChatRoomList(chatRooms);
    }

    public void setSelectedChatRoom(ChatRoom selectedChatRoom) {
        this.selectedChatRoom = selectedChatRoom;
    }

    public ChatRoom getSelectedChatRoom() {
        return selectedChatRoom;
    }

    public String getMessage() {
        return chatField.getMessage();
    }

    public void addSendMessageListener(ActionListener actionListener) {
        chatField.getMessageSendButton().setClickEvent(actionListener);
    }

    public void setChatRoomInfo(String message, String sendAt) {

    }

}
