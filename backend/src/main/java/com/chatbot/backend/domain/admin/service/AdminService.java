package com.chatbot.backend.domain.admin.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.chatbot.backend.domain.category.dto.response.CategoryItemDto;
import com.chatbot.backend.domain.user.dto.request.UserSearchCondition;
import com.chatbot.backend.domain.user.dto.request.UserUpdateRequestDto;
import com.chatbot.backend.domain.user.dto.response.UserBaseResponseDto;
import com.chatbot.backend.global.dto.PageResponseDto;

public interface AdminService {
	CategoryItemDto createCategory(Long userId, String name);

	PageResponseDto findFeedbackByPage(Long userId, Boolean isPositive, Pageable pageable);

	CategoryItemDto updateCategory(Long userId, Long categoryId, String name);

	void deleteCategory(Long userId, Long categoryId);

	UserBaseResponseDto updateUser(Long adminId, Long userId, UserUpdateRequestDto userUpdateRequestDto);

	Page<UserBaseResponseDto> getUserList(Long userId, UserSearchCondition userSearchCondition,
		Pageable pageable);
}
