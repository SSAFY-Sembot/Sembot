package com.chatbot.backend.domain.board.service;

import org.springframework.web.multipart.MultipartFile;

import com.chatbot.backend.domain.board.dto.request.BoardCreateRequest;
import com.chatbot.backend.domain.board.dto.request.BoardUpdateRequest;
import com.chatbot.backend.domain.board.dto.response.BoardDetailResponse;

public interface BoardService {
	BoardDetailResponse createBoard(Long userId, BoardCreateRequest boardCreateRequest, MultipartFile file);

	BoardDetailResponse updateBoard(Long userId, Long boardId, BoardUpdateRequest boardUpdateRequest,
		MultipartFile file);

	void deleteBoard(Long userId, Long boardId);

	BoardDetailResponse getBoard(Long userId, Long boardId);
}