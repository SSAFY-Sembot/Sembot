package com.chatbot.backend.domain.chat.entitiy;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;

@Getter
@Document(collection = "chatfeedbacks")
public class ChatFeedBack {

	@OneToOne(fetch = FetchType.LAZY)
	private Chat chat;

	private boolean isPositive;
	private String negativeReason;
	private LocalDateTime createdAt;

	@Builder
	public ChatFeedBack(Chat chat, boolean isPositive, String negativeReason) {
		this.chat = chat;
		this.isPositive = isPositive;
		this.negativeReason = negativeReason;
		this.createdAt = LocalDateTime.now();

	}

}
