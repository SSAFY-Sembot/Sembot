package com.chatbot.backend.domain.board.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chatbot.backend.domain.board.dto.request.BoardCreateRequest;
import com.chatbot.backend.domain.board.dto.request.BoardUpdateRequest;
import com.chatbot.backend.domain.board.dto.response.BoardDetailResponse;
import com.chatbot.backend.domain.board.service.BoardService;
import com.chatbot.backend.global.security.CustomUserDetails;

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
		@AuthenticationPrincipal CustomUserDetails userDetails,
		@Valid @RequestPart(value = "request") BoardCreateRequest boardCreateRequest,
		@RequestPart(value = "file", required = false) MultipartFile file) {
		Long userId = userDetails.getId();
		return ResponseEntity.ok(boardService.createBoard(userId, boardCreateRequest, file));
	}

	@Operation(
		summary = "게시글 수정",
		description = "게시글을 수정합니다. 제목, 내용, 카테고리, 레벨 정보와 선택적으로 파일을 첨부할 수 있습니다."
	)
	@PutMapping(value = "/{boardId}", consumes = {MediaType.APPLICATION_JSON_VALUE,
		MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<BoardDetailResponse> updateBoard(
		@AuthenticationPrincipal CustomUserDetails userDetails,
		@PathVariable Long boardId,
		@Valid @RequestPart(value = "request") BoardUpdateRequest boardUpdateRequest,
		@RequestPart(value = "file", required = false) MultipartFile file) {
		Long userId = userDetails.getId();
		return ResponseEntity.ok(boardService.updateBoard(userId, boardId, boardUpdateRequest, file));
	}
}