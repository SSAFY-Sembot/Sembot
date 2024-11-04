package com.chatbot.backend.domain.chat.service;

import org.springframework.stereotype.Service;

import com.chatbot.backend.domain.chat.dto.request.CreateChatFeedBackRequestDto;
import com.chatbot.backend.domain.chat.dto.request.CreateChatRequestDto;
import com.chatbot.backend.domain.chat.dto.response.CreateChatFeedBackResponseDto;
import com.chatbot.backend.domain.chat.dto.response.CreateChatResponseDto;
import com.chatbot.backend.domain.chat.entitiy.Chat;
import com.chatbot.backend.domain.chat.entitiy.ChatFeedBack;
import com.chatbot.backend.domain.chat.repository.MongoChatFeedBackRepository;
import com.chatbot.backend.domain.chat.repository.MongoChatRepository;
import com.chatbot.backend.domain.chatroom.entity.ChatRoom;
import com.chatbot.backend.domain.chatroom.repository.ChatRoomRepository;

@Service
public class ChatServiceImpl implements ChatService {

	MongoChatRepository mongoChatRepository;
	ChatRoomRepository chatRoomRepository;
	MongoChatFeedBackRepository chatFeedBackRepository;

	@Override
	public CreateChatResponseDto createChat(CreateChatRequestDto createChatRequestDto) {

		ChatRoom chatRoom = chatRoomRepository.findChatRoomById(createChatRequestDto.getChatRoomId());

		Chat savedChat = mongoChatRepository.save(
			Chat.builder()
				.chatRoom(chatRoom)
				.question(createChatRequestDto.getQuestion())
				.answer(createChatRequestDto.getAnswer())
				.build()
		);
		return new CreateChatResponseDto(
			savedChat.getChatId(),
			savedChat.getQuestion(),
			savedChat.getAnswer()
		);

	}

	@Override
	public CreateChatFeedBackResponseDto createChatFeedBack(String chatId,
		CreateChatFeedBackRequestDto createChatFeedBackRequestDto) {

		Chat chat = mongoChatRepository.findById(chatId).
			orElseThrow();

		ChatFeedBack savedFeedBack = chatFeedBackRepository.save(
			ChatFeedBack.builder()
				.chat(chat)
				.isPositive(createChatFeedBackRequestDto.isPositive())
				.negativeReason(createChatFeedBackRequestDto.getNegativeReason())
				.build()
		);

		return new CreateChatFeedBackResponseDto(
			savedFeedBack.getChat().getChatId(),
			savedFeedBack.isPositive(),
			savedFeedBack.getNegativeReason()
		);
	}
}
