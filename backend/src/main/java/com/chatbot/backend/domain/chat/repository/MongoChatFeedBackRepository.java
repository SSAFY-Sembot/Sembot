package com.chatbot.backend.domain.chat.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.chatbot.backend.domain.chat.entitiy.Chat;
import com.chatbot.backend.domain.chat.entitiy.ChatFeedBack;

@Repository
public interface MongoChatFeedBackRepository extends MongoRepository<ChatFeedBack, String> {
	ChatFeedBack findChatFeedBackByChat(Chat chat);
}
