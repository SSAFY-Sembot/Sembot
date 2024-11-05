package com.chatbot.backend.domain.chat.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CreateChatResponseDto {

	private String chatId;
	private String question;
	private String answer;
}
