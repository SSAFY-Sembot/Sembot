package com.chatbot.backend.domain.chatroom.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import com.chatbot.backend.domain.chat.dto.ChatDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FindChatRoomDetailResponseDto {

	private Long chatRoomId;
	private LocalDateTime createdAt;
	private List<ChatDto> chatList;
}
