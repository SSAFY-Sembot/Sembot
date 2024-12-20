package com.chatbot.backend.domain.admin.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatbot.backend.domain.admin.service.AdminService;
import com.chatbot.backend.domain.category.dto.response.CategoryItemDto;
import com.chatbot.backend.domain.user.dto.request.UserSearchCondition;
import com.chatbot.backend.domain.user.dto.request.UserUpdateRequestDto;
import com.chatbot.backend.domain.user.dto.response.UserBaseResponseDto;
import com.chatbot.backend.global.dto.PageResponseDto;
import com.chatbot.backend.global.security.CustomUserDetails;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Admin", description = "관리자 관련 API")
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/admins")
public class AdminController {
	private final AdminService adminService;

	@GetMapping("/feedbacks")
	public ResponseEntity<PageResponseDto> findFeedbackByPage(
		@AuthenticationPrincipal CustomUserDetails userDetails,
		Boolean isPositive,
		@PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {

		Long userId = userDetails.getId();

		PageResponseDto response = adminService.findFeedbackByPage(userId, isPositive, pageable);
		return ResponseEntity.ok().body(response);
	}

	@PostMapping("/categories")
	public ResponseEntity<CategoryItemDto> createCategory(
		@AuthenticationPrincipal CustomUserDetails userDetails,
		@RequestBody String name) {
		Long userId = userDetails.getId();
		CategoryItemDto category = adminService.createCategory(userId, name);

		return ResponseEntity.ok(category);
	}

	@Operation(
		summary = "카테고리 수정",
		description = "카테고리를 수정합니다. 카테고리 제목을 수정할 수 있습니다."
	)
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryItemDto> updateCategory(
		@AuthenticationPrincipal CustomUserDetails userDetails,
		@PathVariable Long categoryId,
		@RequestBody String name
	) {
		return ResponseEntity.status(HttpStatus.OK)
			.body(adminService.updateCategory(userDetails.getId(), categoryId, name));
	}

	@Operation(
		summary = "카테고리 삭제",
		description = "카테고리를 삭제합니다."
	)
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<Void> deleteCategory(
		@AuthenticationPrincipal CustomUserDetails userDetails,
		@PathVariable Long categoryId
	) {
		adminService.deleteCategory(userDetails.getId(), categoryId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@Operation(
		summary = "회원 정보 수정",
		description = "회원 정보를 수정합니다. 회원의 레벨, 역할을 선택적으로 수정할 수 있습니다."
	)
	@PutMapping("/users/{userId}")
	public ResponseEntity<UserBaseResponseDto> updateUser(
		@AuthenticationPrincipal CustomUserDetails userDetails,
		@PathVariable Long userId,
		@RequestBody UserUpdateRequestDto userUpdateRequestDto
	) {
		return ResponseEntity.status(HttpStatus.OK)
			.body(adminService.updateUser(userDetails.getId(), userId, userUpdateRequestDto));
	}

	@Operation(
		summary = "사용자 정보 목록 조회",
		description = "사용자 정보 목록을 조회합니다."
	)
	@GetMapping("/users")
	public ResponseEntity<PageResponseDto<UserBaseResponseDto>> getUserList(
		@AuthenticationPrincipal CustomUserDetails userDetails,
		@ModelAttribute UserSearchCondition userSearchCondition,
		@PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
	) {
		return ResponseEntity.status(HttpStatus.OK)
			.body(PageResponseDto.of(adminService.getUserList(userDetails.getId(), userSearchCondition, pageable)));
	}
}
