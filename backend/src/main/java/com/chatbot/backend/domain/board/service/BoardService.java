package com.chatbot.backend.domain.board.service;

import org.springframework.web.multipart.MultipartFile;

import com.chatbot.backend.domain.board.dto.request.BoardCreateRequest;
import com.chatbot.backend.domain.board.dto.response.BoardDetailResponse;

public interface BoardService {
	BoardDetailResponse createBoard(Long userId, BoardCreateRequest BoardCreateRequest, MultipartFile file);
}