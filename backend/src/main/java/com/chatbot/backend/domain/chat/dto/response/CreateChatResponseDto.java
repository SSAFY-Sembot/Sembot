package com.chatbot.backend.domain.chat.dto.response;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class CreateChatResponseDto {

	private String chatId;
	private String question;
	private String answer;
}
