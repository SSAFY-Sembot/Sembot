package com.chatbot.backend.domain.category.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class CategoryFindResponseDto {
	List<CategoryItemDto> categories;
}

