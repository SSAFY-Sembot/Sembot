package com.chatbot.backend.domain.chat.dto.response;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateChatFeedBackResponseDto {

	private ObjectId chatId;
	private boolean isPositive;
	private String negativeReason;

}
