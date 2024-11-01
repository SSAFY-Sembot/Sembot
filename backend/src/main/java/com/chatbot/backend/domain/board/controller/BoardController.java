package com.chatbot.backend.domain.board.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chatbot.backend.domain.board.dto.request.BoardCreateRequest;
import com.chatbot.backend.domain.board.dto.response.BoardDetailResponse;
import com.chatbot.backend.domain.board.service.BoardService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Board", description = "규정 게시판 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/boards")
@Slf4j
public class BoardController {
	private final BoardService boardService;

	@Operation(
		summary = "게시글 생성",
		description = "새로운 게시글을 생성합니다. 제목, 내용, 카테고리, 레벨 정보와 선택적으로 파일을 첨부할 수 있습니다."
	)
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<BoardDetailResponse> createBoard(
		// TODO
		// User 구현 이후, token을 Header로 받는 방식으로 변경할 예정
		// Authentication authentication,
		@RequestParam Long userId,
		@Valid @RequestPart(value = "request") BoardCreateRequest BoardCreateRequest,
		@RequestPart(value = "file", required = false) MultipartFile file) {
		// Long userId = (long)authentication.getPrincipal();
		return ResponseEntity.ok(boardService.createBoard(userId, BoardCreateRequest, file));
	}
}