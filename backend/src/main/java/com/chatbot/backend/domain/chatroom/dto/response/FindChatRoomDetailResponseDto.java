package com.chatbot.backend.domain.chatroom.dto.response;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.chatbot.backend.domain.chat.entity.Chat;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FindChatRoomDetailResponseDto {

	private Long chatRoomId;
	private String title;
	private LocalDateTime createdAt;
	private List<Chat> chatList = new ArrayList<>();
}
