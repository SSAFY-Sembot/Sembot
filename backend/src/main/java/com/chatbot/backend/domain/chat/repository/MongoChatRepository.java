package com.chatbot.backend.domain.chat.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.chatbot.backend.domain.chat.entitiy.Chat;

@Repository
public interface MongoChatRepository extends MongoRepository<Chat, Long> {

	List<Chat> findAllByChatRoom_IdOrderByCreatedAtDesc(Long chatRoomId);
}
