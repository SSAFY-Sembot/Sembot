package com.chatbot.backend.domain.chatroom.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chatbot.backend.domain.chatroom.entity.ChatRoom;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

	Page<ChatRoom> findAllByUserIdAndDeletedFalseOrderByCreatedAtDesc(Long userId, Pageable pageable);

	ChatRoom findChatRoomById(Long chatRoomId);
}
