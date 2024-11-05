package com.chatbot.backend.domain.chat.dto.response;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateChatFeedBackResponseDto {

	private ObjectId chatId;
	private boolean isPositive;
	private String negativeReason;

}
