package com.chatbot.backend.domain.chat.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatbot.backend.domain.chat.dto.request.CreateChatFeedBackRequestDto;
import com.chatbot.backend.domain.chat.dto.request.CreateChatRequestDto;
import com.chatbot.backend.domain.chat.dto.response.CreateChatFeedBackResponseDto;
import com.chatbot.backend.domain.chat.dto.response.CreateChatResponseDto;
import com.chatbot.backend.domain.chat.service.ChatService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/chats")
@RequiredArgsConstructor
public class ChatController {

	private final ChatService chatService;

	@PostMapping("")
	public ResponseEntity<CreateChatResponseDto> createChat(
		@RequestBody CreateChatRequestDto createChatRequestDto
	) {
		CreateChatResponseDto createChatResponseDto = chatService.createChat(createChatRequestDto);
		return ResponseEntity.ok().body(createChatResponseDto);
	}

	@PostMapping("/{chatId}/feedback")
	public ResponseEntity<CreateChatFeedBackResponseDto> createChatFeedBack(
		@PathVariable String chatId,
		@RequestBody CreateChatFeedBackRequestDto createChatFeedBackRequestDto) {

		CreateChatFeedBackResponseDto chatFeedBack = chatService.createChatFeedBack(chatId,
			createChatFeedBackRequestDto);

		return ResponseEntity.ok().body(chatFeedBack);
	}

}

