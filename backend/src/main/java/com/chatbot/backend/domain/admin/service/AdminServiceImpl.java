package com.chatbot.backend.domain.admin.service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.chatbot.backend.domain.admin.dto.request.FeedbackRequestDto;
import com.chatbot.backend.domain.admin.dto.response.FeedbackResponseDto;
import com.chatbot.backend.domain.admin.exception.NoAuthorityException;
import com.chatbot.backend.domain.category.entity.Category;
import com.chatbot.backend.domain.category.exception.CategoryAlreadyExistsException;
import com.chatbot.backend.domain.category.repository.CategoryRepository;
import com.chatbot.backend.domain.chat.entitiy.Chat;
import com.chatbot.backend.domain.chat.entitiy.ChatFeedBack;
import com.chatbot.backend.domain.chat.repository.MongoChatFeedBackRepository;
import com.chatbot.backend.domain.chat.repository.MongoChatRepository;
import com.chatbot.backend.domain.user.entity.User;
import com.chatbot.backend.domain.user.repository.UserRepository;
import com.chatbot.backend.global.jwt.JwtProvider;
import com.chatbot.backend.global.jwt.Role;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminServiceImpl implements AdminService {

	private final CategoryRepository categoryRepository;
	private final UserRepository userRepository;
	private final MongoChatFeedBackRepository mongoChatFeedBackRepository;
	private final MongoChatRepository mongoChatRepository;

	@Override
	public FeedbackResponseDto findCategoryByPage(Long userId, FeedbackRequestDto request) {
		User user = userRepository.findByIdOrElseThrow(userId);
		if(user.getRole() != Role.ADMIN){
			throw new NoAuthorityException();
		}


		List<Chat> chats = mongoChatRepository.findAllByChatRoomIdOrderByCreatedAtDesc();
		ChatFeedBack chatFeedBack = mongoChatFeedBackRepository.findChatFeedBackByChatId(new ObjectId());
		return null;
	}

	@Override
	public void createCategory(Long userId, String name) {
		User user = userRepository.findByIdOrElseThrow(userId);
		if(user.getRole() != Role.ADMIN){
			throw new NoAuthorityException();
		}

		Optional<Category> category = categoryRepository.findByName(name);
		if (category.isPresent()) {
			throw new CategoryAlreadyExistsException();
		}

		Category adminCategory = Category.builder()
			.name(name)
			.isDeleted(false)  // isDeleted 기본값 설정
			.build();
		categoryRepository.save(adminCategory);
	}


}
