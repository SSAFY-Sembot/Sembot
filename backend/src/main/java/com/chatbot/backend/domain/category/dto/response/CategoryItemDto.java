package com.chatbot.backend.domain.category.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class CategoryItemDto {
	private Long categoryId;
	private String name;
}
