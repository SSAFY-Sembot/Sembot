package com.chatbot.backend.domain.chatroom.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateChatRoomResponseDto {

	private Long chatRoomId;
	private String title;

	public CreateChatRoomResponseDto(Long chatRoomId, String title) {
		this.chatRoomId = chatRoomId;
		this.title = title;
	}
}
