package com.chatbot.backend.domain.chat.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateChatRequestDto {

	private Long chatRoomId;
	private String question;
	private String answer;

}
