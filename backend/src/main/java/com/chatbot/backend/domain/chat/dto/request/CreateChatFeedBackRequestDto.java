package com.chatbot.backend.domain.chat.dto.request;

import lombok.Getter;

@Getter
public class CreateChatFeedBackRequestDto {

	private String chatId;
	private boolean isPositive;
	private String negativeReason;

}
