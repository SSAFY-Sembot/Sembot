package com.chatbot.backend.domain.admin.service;

import com.chatbot.backend.domain.admin.dto.request.FeedbackRequestDto;
import com.chatbot.backend.domain.admin.dto.response.FeedbackResponseDto;

public interface AdminService {
	void createCategory(Long userId, String name);
	FeedbackResponseDto findCategoryByPage(Long userId, FeedbackRequestDto request);
}
