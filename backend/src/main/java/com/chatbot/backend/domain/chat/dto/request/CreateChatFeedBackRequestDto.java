package com.chatbot.backend.domain.chat.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateChatFeedBackRequestDto {

	private String chatId;
	private boolean isPositive;
	private String negativeReason;

}
