package com.chatbot.backend.domain.chatroom.service;


import com.chatbot.backend.domain.chatroom.dto.request.CreateChatRoomRequestDto;
import com.chatbot.backend.domain.chatroom.dto.request.DeleteChatRoomRequestDto;
import com.chatbot.backend.domain.chatroom.dto.request.FindChatRoomDetailRequestDto;
import com.chatbot.backend.domain.chatroom.dto.request.FindChatRoomListRequestDto;
import com.chatbot.backend.domain.chatroom.dto.response.CreateChatRoomResponseDto;
import com.chatbot.backend.domain.chatroom.dto.response.DeleteChatRoomResponseDto;
import com.chatbot.backend.domain.chatroom.dto.response.FindChatRoomDetailResponseDto;
import com.chatbot.backend.domain.chatroom.dto.response.FindChatRoomListResponseDto;
import com.chatbot.backend.global.security.CustomUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

public interface ChatRoomService {

    CreateChatRoomResponseDto createChatRoom(CreateChatRoomRequestDto createChatRoomRequestDto);

    FindChatRoomListResponseDto findChatRoomList(FindChatRoomListRequestDto findChatRoomRequestDto);

    FindChatRoomDetailResponseDto findChatRoomDetail(FindChatRoomDetailRequestDto findChatRoomDetailRequestDto);

    DeleteChatRoomResponseDto deleteChatRoom(DeleteChatRoomRequestDto deleteChatRoomRequestDto);
}
