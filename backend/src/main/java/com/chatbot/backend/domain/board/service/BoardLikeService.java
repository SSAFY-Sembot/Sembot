package com.chatbot.backend.domain.board.service;

public interface BoardLikeService {
	void createBoardLike(Long userId, Long boardId);

	void deleteBoardLike(Long userId, Long boardId);
}
