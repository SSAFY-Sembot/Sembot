package com.chatbot.backend.domain.chat.entitiy;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

import com.chatbot.backend.domain.chatroom.entity.ChatRoom;

@Document(collation = "chats")
public class Chat {

	@Id
	@GeneratedValue
	private Long chatId;

	private String question;
	private String answer;
	private LocalDateTime createdAt;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHATFEEDBACK_ID")
	private ChatFeedBack chatFeedBack;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHATROOM_ID")
	private ChatRoom chatRoom;

}
