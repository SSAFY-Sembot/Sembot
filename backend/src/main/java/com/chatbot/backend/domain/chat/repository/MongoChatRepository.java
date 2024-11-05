package com.chatbot.backend.domain.chat.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.chatbot.backend.domain.chat.entitiy.Chat;

@Repository
public interface MongoChatRepository extends MongoRepository<Chat, ObjectId> {

	List<Chat> findAllByChatRoomIdOrderByCreatedAtDesc(Long chatRoomId);
}
