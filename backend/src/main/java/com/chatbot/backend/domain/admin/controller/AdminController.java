package com.chatbot.backend.domain.admin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatbot.backend.domain.admin.service.AdminService;
import com.chatbot.backend.domain.category.dto.response.CategoryResponseDto;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/admins")
public class AdminController {

	private final AdminService adminService;

	// @GetMapping("/feedbacks")
	// public ResponseEntity<Page<FeedbackResponseDto>> getFeedbacks(@RequestParam Boolean isPositive, @RequestParam Integer page,
	// 	@RequestParam Integer size, @RequestParam String sortBy, @RequestParam String sortDir) {
	// 	ResponseEntity<?> response = adminService.getFeedbacks(isPositive,page,size,sortBy,sortDir);
	// 	return ResponseEntity.ok().body(response);
	// }

	@PostMapping("/categories")
	public ResponseEntity<CategoryResponseDto> postCategory(HttpServletRequest request, @RequestBody String name){
		adminService.postCategory(request, name);
		return ResponseEntity.ok().build();
	}

}
