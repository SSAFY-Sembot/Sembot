package com.chatbot.backend.domain.chat.dto.response;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateChatFeedBackResponseDto {

	private String chatId;
	private boolean isPositive;
	private String negativeReason;

}
