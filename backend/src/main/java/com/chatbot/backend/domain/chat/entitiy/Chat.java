package com.chatbot.backend.domain.chat.entitiy;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import com.chatbot.backend.domain.chatroom.entity.ChatRoom;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Document(collation = "chats")
public class Chat {

	@Id
	@GeneratedValue
	private Long chatId;

	private String question;
	private String answer;
	private LocalDateTime createdAt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHATROOM_ID")
	private ChatRoom chatRoom;

}
