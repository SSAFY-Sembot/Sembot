package com.chatbot.backend.domain.chat.dto.request;

import lombok.Setter;

@Setter
public class CreateChatRequestDto {

	private Long userId;
	private String question;
	private String answer;
}
