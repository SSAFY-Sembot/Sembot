package com.chatbot.backend.domain.chat.service;

import com.chatbot.backend.domain.chat.dto.request.CreateChatFeedBackRequestDto;
import com.chatbot.backend.domain.chat.dto.request.CreateChatRequestDto;
import com.chatbot.backend.domain.chat.dto.response.CreateChatFeedBackResponseDto;
import com.chatbot.backend.domain.chat.dto.response.CreateChatResponseDto;

public interface ChatService {

	CreateChatResponseDto createChat(CreateChatRequestDto createChatRequestDto);

	CreateChatFeedBackResponseDto createChatFeedBack(Long chatId,
		CreateChatFeedBackRequestDto sendChatFeedBackRequestDto);
}
