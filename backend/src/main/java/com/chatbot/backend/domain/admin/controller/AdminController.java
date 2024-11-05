package com.chatbot.backend.domain.admin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatbot.backend.domain.admin.dto.request.FeedbackRequestDto;
import com.chatbot.backend.domain.admin.dto.response.FeedbackResponseDto;
import com.chatbot.backend.domain.admin.service.AdminService;
import com.chatbot.backend.domain.category.dto.request.CategoryFindRequestDto;
import com.chatbot.backend.domain.category.dto.response.CategoryFindResponseDto;
import com.chatbot.backend.global.security.CustomUserDetails;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/admins")
public class AdminController {

	private final AdminService adminService;

	@GetMapping("/feedbacks")
	public ResponseEntity<FeedbackResponseDto> findCategoryByPage(
		@AuthenticationPrincipal CustomUserDetails userDetails,
		FeedbackRequestDto request){
		Long userId = userDetails.getId();
		FeedbackResponseDto response = adminService.findCategoryByPage(userId, request);
		return ResponseEntity.ok().body(response);
	}

	@PostMapping("/categories")
	public ResponseEntity<CategoryFindResponseDto> createCategory(
		@AuthenticationPrincipal CustomUserDetails userDetails,
		@RequestBody String name){
		Long userId = userDetails.getId();
		adminService.createCategory(userId, name);
		return ResponseEntity.ok().build();
	}

}
