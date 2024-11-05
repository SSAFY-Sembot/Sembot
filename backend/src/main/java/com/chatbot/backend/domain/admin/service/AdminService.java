package com.chatbot.backend.domain.admin.service;



import org.springframework.data.domain.Pageable;

import com.chatbot.backend.domain.admin.dto.response.FeedbackResponseDto;

public interface AdminService {
	void createCategory(Long userId, String name);
	FeedbackResponseDto findFeedbackByPage(Long userId, Pageable pageable);
}
