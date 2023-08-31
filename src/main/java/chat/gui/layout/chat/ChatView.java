package chat.gui.layout.chat;

import chat.gui.layout.chat.view.ChatField;
import chat.gui.layout.chat.view.ChatRoom;
import chat.gui.layout.chat.view.ChatRoomList;
import chat.gui.components.Panel;
import chat.module.dto.ChatRoomDTO;
import chat.module.dto.MessageDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ChatView extends Panel {

    private final ChatRoomList chatRoomList;
    private final ChatField chatField;

    private Map<Long, ChatRoom> chatRoomMap;
    private ChatRoom selectedChatRoom;
    private List<ChatRoom> chatRooms;

    public ChatView() {
        chatRoomList = new ChatRoomList();
        chatField = new ChatField();
        chatRoomMap = new ConcurrentHashMap<>();

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

        this.chatRooms = chatRooms;
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

    public ChatRoom getChatRoomComponent(Long no) {
        for(ChatRoom item : chatRooms) {
            ChatRoomDTO dto = item.getChatroomDTO();

            if(dto.getNo() == no) {
                return item;
            }
        }
        return null;
    }

    public void refresh(ChatRoomDTO chatRoomDTO, MessageDTO messageDTO) {
        ChatRoom chatroom = getChatRoomComponent(chatRoomDTO.getNo());
        chatroom.refresh(messageDTO.getContent(), messageDTO.getSendAt());

        chatRoomList.moveChatRoomToTop(chatroom);

        revalidate();
        repaint();
    }

    public void addClickGroupAddListener(ActionListener actionListener) {
        chatRoomList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                actionListener.actionPerformed(null);
            }
        });
    }

    public void addClickImageLabelListener(ActionListener actionListener) {
        chatField.getImageLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                actionListener.actionPerformed(null);
            }
        });
    }
}
