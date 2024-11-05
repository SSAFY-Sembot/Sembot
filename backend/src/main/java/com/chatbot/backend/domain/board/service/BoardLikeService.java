package com.chatbot.backend.domain.board.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import com.chatbot.backend.domain.board.dto.response.BoardBaseResponse;

public interface BoardLikeService {
	void createBoardLike(Long userId, Long boardId);

	void deleteBoardLike(Long userId, Long boardId);

	Slice<BoardBaseResponse> getFavoriteBoardList(Long userId, Pageable pageable);
}
