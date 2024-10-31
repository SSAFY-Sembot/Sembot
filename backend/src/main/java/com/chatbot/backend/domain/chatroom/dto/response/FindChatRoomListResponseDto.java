package com.chatbot.backend.domain.chatroom.dto.response;

import org.springframework.data.domain.Page;

import com.chatbot.backend.domain.chatroom.dto.ChatRoomDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FindChatRoomListResponseDto {

	private Page<ChatRoomDto> contents;
	private boolean hasNext;

}
