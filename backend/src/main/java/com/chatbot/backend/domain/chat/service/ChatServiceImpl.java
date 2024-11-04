package com.chatbot.backend.domain.chat.service;

import org.springframework.stereotype.Service;

import com.chatbot.backend.domain.chat.dto.request.CreateChatFeedBackRequestDto;
import com.chatbot.backend.domain.chat.dto.request.CreateChatRequestDto;
import com.chatbot.backend.domain.chat.dto.response.CreateChatFeedBackResponseDto;
import com.chatbot.backend.domain.chat.dto.response.CreateChatResponseDto;
import com.chatbot.backend.domain.chat.repository.MongoChatRepository;

@Service
public class ChatServiceImpl implements ChatService {

	MongoChatRepository mongoChatRepository;

	@Override
	public CreateChatResponseDto createChat(CreateChatRequestDto createChatRequestDto) {
		mongoChatRepository.save(
	}

	@Override
	public CreateChatFeedBackResponseDto createChatFeedBack(Long chatId, CreateChatFeedBackRequestDto sendChatFeedBackRequestDto) {
		return null;
	}
}
