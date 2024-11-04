package com.chatbot.backend.domain.board.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.chatbot.backend.domain.board.dto.request.BoardCreateRequest;
import com.chatbot.backend.domain.board.dto.request.BoardUpdateRequest;
import com.chatbot.backend.domain.board.dto.response.BoardDetailResponse;
import com.chatbot.backend.domain.board.entity.Board;
import com.chatbot.backend.domain.board.entity.BoardLike;
import com.chatbot.backend.domain.board.exception.BoardAccessDeniedException;
import com.chatbot.backend.domain.board.exception.BoardCreationNotAuthorizedException;
import com.chatbot.backend.domain.board.exception.BoardUnauthorizedException;
import com.chatbot.backend.domain.board.repository.BoardLikeRepository;
import com.chatbot.backend.domain.board.repository.BoardRepository;
import com.chatbot.backend.domain.category.entity.Category;
import com.chatbot.backend.domain.category.repository.CategoryRepository;
import com.chatbot.backend.domain.file.service.FileService;
import com.chatbot.backend.domain.user.entity.User;
import com.chatbot.backend.domain.user.repository.UserRepository;
import com.chatbot.backend.global.jwt.Role;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class BoardServiceImpl implements BoardService {
	private static final String BOARD_UPLOAD_DIR = "boards";

	private final BoardRepository boardRepository;
	private final UserRepository userRepository;
	private final FileService fileService;
	private final CategoryRepository categoryRepository;
	private final BoardLikeRepository boardLikeRepository;

	@Override
	public BoardDetailResponse createBoard(Long userId, BoardCreateRequest boardCreateRequest, MultipartFile file) {
		// 검증
		User user = userRepository.findByIdOrElseThrow(userId);
		Category category = categoryRepository.findByNameOrElseThrow(boardCreateRequest.category());
		validateUserWriteAuthorized(user);

		// Board 생성 (비즈니스 로직)
		Board board = boardCreateRequest.toEntity(user, category, fileService.saveFile(file, BOARD_UPLOAD_DIR));
		Board savedBoard = boardRepository.save(board);

		return BoardDetailResponse.of(savedBoard);
	}

	@Override
	public BoardDetailResponse updateBoard(Long userId, Long boardId, BoardUpdateRequest boardUpdateRequest,
		MultipartFile file) {
		// 검증 & 조회
		User user = userRepository.findByIdOrElseThrow(userId);
		Category category = categoryRepository.findByNameOrElseThrow(boardUpdateRequest.category());
		Board board = boardRepository.findByIdOrElseThrow(boardId);
		BoardLike boardLike = boardLikeRepository.findByBoardIdAndUserId(boardId, userId).orElse(null);
		validateUserAuthorizationForBoard(user, board);

		// Board 수정 (비즈니스 로직)
		board.updateBoard(boardUpdateRequest, category, fileService.saveFile(file, BOARD_UPLOAD_DIR));

		return BoardDetailResponse.of(board, boardLike);
	}

	@Override
	public void deleteBoard(Long userId, Long boardId) {
		User user = userRepository.findByIdOrElseThrow(userId);
		Board board = boardRepository.findByIdOrElseThrow(boardId);
		validateUserAuthorizationForBoard(user, board);

		board.deleteBoard();
	}

	@Override
	public BoardDetailResponse getBoard(Long userId, Long boardId) {
		User user = userRepository.findByIdOrElseThrow(userId);
		Board board = boardRepository.findByIdOrElseThrow(boardId);
		BoardLike boardLike = boardLikeRepository.findByBoardIdAndUserId(boardId, userId).orElse(null);
		validateUserHasAccess(user, board);

		return BoardDetailResponse.of(board, boardLike);
	}

	// 사용자가 쓰기 권한이 있는 지 검증 (검증 로직)
	private void validateUserWriteAuthorized(User user) {
		if (user.getRole() != Role.USER_WRITE) {
			throw new BoardCreationNotAuthorizedException();
		}
	}

	// 사용자가 게시글을 수정 / 삭제할 권한이 있는 지 검증 (검증 로직)
	private void validateUserAuthorizationForBoard(User user, Board board) {
		if (user.getId() != board.getUser().getId()) {
			throw new BoardUnauthorizedException();
		}
	}

	private void validateUserHasAccess(User user, Board board) {
		if (user.getLevel() < board.getLevel()) {
			throw new BoardAccessDeniedException();
		}
	}
}