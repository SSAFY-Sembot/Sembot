package com.chatbot.backend.domain.chat.entitiy;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "chats")
@Getter
public class Chat {

	@Id
	private ObjectId chatId;

	private String question;
	private String answer;
	private LocalDateTime createdAt;

	@Setter
	private Long chatRoomId;

	@DBRef
	@Setter
	private ChatFeedBack chatFeedBack;

	@Builder
	public Chat(String question, String answer, Long chatRoomId) {
		this.question = question;
		this.answer = answer;
		this.chatRoomId = chatRoomId;
		this.createdAt = LocalDateTime.now();
	}

}
