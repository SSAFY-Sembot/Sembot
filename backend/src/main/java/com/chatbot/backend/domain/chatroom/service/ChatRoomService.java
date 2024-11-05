package com.chatbot.backend.domain.chatroom.service;

import org.springframework.data.domain.Pageable;

import com.chatbot.backend.domain.chatroom.dto.request.CreateChatRoomRequestDto;
import com.chatbot.backend.domain.chatroom.dto.response.CreateChatRoomResponseDto;
import com.chatbot.backend.domain.chatroom.dto.response.FindChatRoomDetailResponseDto;
import com.chatbot.backend.domain.chatroom.dto.response.FindChatRoomListResponseDto;

public interface ChatRoomService {

	CreateChatRoomResponseDto createChatRoom(Long userId, CreateChatRoomRequestDto createChatRoomRequestDto);

	FindChatRoomListResponseDto findChatRoomList(Long userId,
		Pageable pageable);

	FindChatRoomDetailResponseDto findChatRoomDetail(Long chatRoomId);

	void deleteChatRoom(Long chatRoomId);
}
