package com.chatbot.backend.domain.board.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatbot.backend.domain.board.dto.request.CreateBoardRequest;
import com.chatbot.backend.domain.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController("/api/board")
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;

	@PostMapping
	ResponseEntity<Void> createBoard(Authentication authentication, CreateBoardRequest createBoardRequest) {
		Long userId = (long)authentication.getPrincipal();
		boardService.createBoard(createBoardRequest);
		return ResponseEntity.ok().build();
	}
}