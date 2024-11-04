package com.chatbot.backend.domain.category.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chatbot.backend.domain.category.dto.response.CategoryItem;
import com.chatbot.backend.domain.category.dto.response.CategoryResponseDto;
import com.chatbot.backend.domain.category.entity.Category;
import com.chatbot.backend.domain.category.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;

	@Override
	public CategoryResponseDto getCategories() {
		List<Category> categories = categoryRepository.findAll();
		List<CategoryItem> categoryItemList =
			categories.stream()
				.map(category -> new CategoryItem(category.getId(), category.getName().trim()))
				.toList();

		return new CategoryResponseDto(categoryItemList);
	}
}
