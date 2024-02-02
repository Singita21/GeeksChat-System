package com.codreal.chatservice.services;

import com.codreal.chatservice.exceptions.ChatAlreadyExistException;
import com.codreal.chatservice.exceptions.ChatNotFoundException;
import com.codreal.chatservice.exceptions.NoChatExistsInTheRepository;
import com.codreal.chatservice.model.Chat;
import com.codreal.chatservice.model.Message;

import java.util.List;

public interface ChatService {

    public Chat addChat(Chat chat) throws ChatAlreadyExistException;

    List<Chat> findallchats() throws NoChatExistsInTheRepository;

    Chat getById(int id)  throws ChatNotFoundException;

    List<Chat> getChatByFirstUserName(String username)  throws ChatNotFoundException;

    List<Chat> getChatBySecondUserName(String username)  throws ChatNotFoundException;

    List<Chat> getChatByFirstUserNameOrSecondUserName(String username)  throws ChatNotFoundException;

    List<Chat> getChatByFirstUserNameAndSecondUserName(String firstUserName, String secondUserName)  throws ChatNotFoundException;

    Chat addMessage(Message add, int chatId)  throws ChatNotFoundException;
}
