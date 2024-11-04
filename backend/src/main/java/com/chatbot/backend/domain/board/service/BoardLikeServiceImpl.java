package com.chatbot.backend.domain.board.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chatbot.backend.domain.board.entity.Board;
import com.chatbot.backend.domain.board.entity.BoardLike;
import com.chatbot.backend.domain.board.repository.BoardLikeRepository;
import com.chatbot.backend.domain.board.repository.BoardRepository;
import com.chatbot.backend.domain.board.util.BoardValidator;
import com.chatbot.backend.domain.user.entity.User;
import com.chatbot.backend.domain.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class BoardLikeServiceImpl implements BoardLikeService {
	private final BoardLikeRepository boardLikeRepository;
	private final UserRepository userRepository;
	private final BoardRepository boardRepository;
	private final BoardValidator boardValidator;

	@Override
	public void createBoardLike(Long userId, Long boardId) {
		// 검증 & 조회
		User user = userRepository.findByIdOrElseThrow(userId);
		Board board = boardRepository.findByIdOrElseThrow(boardId);

		boardValidator.validateBoardLikeExist(boardId, userId);
		boardValidator.validateBoardAccess(user, board);

		// 즐겨찾기 저장 (비즈니스 로직)
		boardLikeRepository.save(
			BoardLike.builder()
				.user(user)
				.board(board)
				.build());
	}
}
