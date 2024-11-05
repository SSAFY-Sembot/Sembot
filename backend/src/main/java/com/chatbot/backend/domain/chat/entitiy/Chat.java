package com.chatbot.backend.domain.chat.entitiy;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.chatbot.backend.domain.chatroom.entity.ChatRoom;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHATFEEDBACK_ID")
	private ChatFeedBack chatFeedBack;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHATROOM_ID")
	private ChatRoom chatRoom;

	@Builder
	public Chat(String question, String answer, ChatRoom chatRoom) {
		this.question = question;
		this.answer = answer;
		this.chatRoom = chatRoom;
		this.createdAt = LocalDateTime.now();
	}

}
