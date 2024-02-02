package com.codreal.chatservice.repository;

import com.codreal.chatservice.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer> {

    List<Chat> getChatByFirstUserName(String username);

    List<Chat> getChatBySecondUserName(String username);

    List<Chat> getChatByFirstUserNameAndSecondUserName(String firstUserName, String secondUserName);

    List<Chat> getChatBySecondUserNameAndFirstUserName(String firstUserName, String secondUserName);
}


