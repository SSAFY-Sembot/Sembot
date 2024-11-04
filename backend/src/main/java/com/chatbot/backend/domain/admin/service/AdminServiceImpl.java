package com.chatbot.backend.domain.admin.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.chatbot.backend.domain.admin.exception.NoAuthorityException;
import com.chatbot.backend.domain.category.entity.Category;
import com.chatbot.backend.domain.category.exception.CategoryAlreadyExistsException;
import com.chatbot.backend.domain.category.repository.CategoryRepository;
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
	private final JwtProvider jwtProvider;
	private final UserRepository userRepository;

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
