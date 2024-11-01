package com.chatbot.backend.domain.chatroom.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateChatRoomRequestDto {

	private Long userId;
	private String content;
}
