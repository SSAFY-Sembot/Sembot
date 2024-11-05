package com.chatbot.backend.domain.chat.entity;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;

@Getter
@Document(collection = "chatfeedbacks")
public class ChatFeedBack {

	@Id
	private ObjectId ChatFeedBackId;

	private ObjectId chatId;

	private boolean isPositive;
	private String negativeReason;
	private LocalDateTime createdAt;

	@Builder
	public ChatFeedBack(ObjectId chatId, boolean isPositive, String negativeReason) {
		this.chatId = chatId;
		this.isPositive = isPositive;
		this.negativeReason = negativeReason;
		this.createdAt = LocalDateTime.now();

	}

}
