package com.chatbot.backend.domain.category.service;

import com.chatbot.backend.domain.category.dto.response.CategoryFindResponseDto;

public interface CategoryService {
	CategoryFindResponseDto getCategoryList();
}
