package com.chatbot.backend.domain.chatroom.service;

import org.springframework.data.domain.Pageable;

import com.chatbot.backend.domain.chatroom.dto.request.CreateChatRoomRequestDto;
import com.chatbot.backend.domain.chatroom.dto.request.DeleteChatRoomRequestDto;
import com.chatbot.backend.domain.chatroom.dto.request.FindChatRoomListRequestDto;
import com.chatbot.backend.domain.chatroom.dto.response.CreateChatRoomResponseDto;
import com.chatbot.backend.domain.chatroom.dto.response.DeleteChatRoomResponseDto;
import com.chatbot.backend.domain.chatroom.dto.response.FindChatRoomDetailResponseDto;
import com.chatbot.backend.domain.chatroom.dto.response.FindChatRoomListResponseDto;

public interface ChatRoomService {

	CreateChatRoomResponseDto createChatRoom(CreateChatRoomRequestDto createChatRoomRequestDto);

	FindChatRoomListResponseDto findChatRoomList(FindChatRoomListRequestDto findChatRoomRequestDto,
		Pageable pageable);

	FindChatRoomDetailResponseDto findChatRoomDetail(Long chatRoomID);

	DeleteChatRoomResponseDto deleteChatRoom(DeleteChatRoomRequestDto deleteChatRoomRequestDto);
}
