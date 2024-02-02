package com.codreal.chatservice.services;

import com.codreal.chatservice.exceptions.ChatNotFoundException;
import com.codreal.chatservice.exceptions.NoChatExistsInTheRepository;
import com.codreal.chatservice.model.Chat;
import com.codreal.chatservice.model.Message;
import com.codreal.chatservice.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;
    private final SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public ChatServiceImpl(ChatRepository chatRepository, SequenceGeneratorService sequenceGeneratorService) {
        this.chatRepository = chatRepository;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    public Chat addChat(Chat chat) {
        chat.setChatId(sequenceGeneratorService.generateSequence(Chat.SEQUENCE_NAME));
        return chatRepository.save(chat);
    }

    @Override
    public List<Chat> findallchats() throws NoChatExistsInTheRepository {
        List<Chat> allChats = chatRepository.findAll();
        if (allChats.isEmpty()) {
            throw new NoChatExistsInTheRepository();
        } else {
            return allChats;
        }
    }

    @Override
    public Chat getById(int id) throws ChatNotFoundException {
        return chatRepository.findById(id)
                .orElseThrow(ChatNotFoundException::new);
    }

    @Override
    public List<Chat> getChatByFirstUserName(String username) throws ChatNotFoundException {
        List<Chat> chatList = chatRepository.getChatByFirstUserName(username);
        if (chatList.isEmpty()) {
            throw new ChatNotFoundException();
        } else {
            return chatList;
        }
    }

    @Override
    public List<Chat> getChatBySecondUserName(String username) throws ChatNotFoundException {
        List<Chat> chatList = chatRepository.getChatBySecondUserName(username);
        if (chatList.isEmpty()) {
            throw new ChatNotFoundException();
        } else {
            return chatList;
        }
    }

    @Override
    public List<Chat> getChatByFirstUserNameOrSecondUserName(String username) throws ChatNotFoundException {
        List<Chat> chatList = new ArrayList<>(chatRepository.getChatByFirstUserName(username));
        chatList.addAll(chatRepository.getChatBySecondUserName(username));

        if (chatList.isEmpty()) {
            throw new ChatNotFoundException();
        } else {
            return chatList;
        }
    }

    @Override
    public List<Chat> getChatByFirstUserNameAndSecondUserName(String firstUserName, String secondUserName) throws ChatNotFoundException {
        List<Chat> chatList = new ArrayList<>(chatRepository.getChatByFirstUserNameAndSecondUserName(firstUserName, secondUserName));
        chatList.addAll(chatRepository.getChatBySecondUserNameAndFirstUserName(firstUserName, secondUserName));

        if (chatList.isEmpty()) {
            throw new ChatNotFoundException();
        } else {
            return chatList;
        }
    }

    @Override
    public Chat addMessage(Message add, int chatId) throws ChatNotFoundException {
        Optional<Chat> optionalChat = chatRepository.findById(chatId);
        Chat existingChat = optionalChat.orElseThrow(ChatNotFoundException::new);

        List<Message> messageList = Optional.ofNullable(existingChat.getMessageList()).orElse(new ArrayList<>());
        messageList.add(add);
        existingChat.setMessageList(messageList);

        return chatRepository.save(existingChat);
    }
}
