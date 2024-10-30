package com.chatbot.backend.domain.board.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatbot.backend.domain.board.dto.request.CreateBoardRequest;
import com.chatbot.backend.domain.board.service.BoardService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "규정", description = "규정 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
@Slf4j
public class BoardController {
	private final BoardService boardService;

	@PostMapping
	public ResponseEntity<Void> createBoard(Authentication authentication, CreateBoardRequest createBoardRequest) {
		Long userId = (long)authentication.getPrincipal();
		boardService.createBoard(createBoardRequest);
		return ResponseEntity.ok().build();
	}
}