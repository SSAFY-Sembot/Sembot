package com.chatbot.backend.domain.category.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatbot.backend.domain.category.dto.response.CategoryResponseDto;
import com.chatbot.backend.domain.category.service.CategoryService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/categories")
public class CategoryController {
	private final CategoryService categoryService;

	@GetMapping
	public ResponseEntity<CategoryResponseDto> getCategories(){
		CategoryResponseDto response = categoryService.getCategories();
		log.info(response.toString());
		return ResponseEntity.ok().body(response);
	}

}
