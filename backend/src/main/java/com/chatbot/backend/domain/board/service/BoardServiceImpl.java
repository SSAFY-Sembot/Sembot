package com.chatbot.backend.domain.board.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.chatbot.backend.domain.board.dto.request.BoardCreateRequest;
import com.chatbot.backend.domain.board.dto.request.BoardUpdateRequest;
import com.chatbot.backend.domain.board.dto.response.BoardDetailResponse;
import com.chatbot.backend.domain.board.entity.Board;
import com.chatbot.backend.domain.board.entity.BoardLike;
import com.chatbot.backend.domain.board.repository.BoardLikeRepository;
import com.chatbot.backend.domain.board.repository.BoardRepository;
import com.chatbot.backend.domain.board.util.BoardValidator;
import com.chatbot.backend.domain.category.entity.Category;
import com.chatbot.backend.domain.category.repository.CategoryRepository;
import com.chatbot.backend.domain.file.service.FileService;
import com.chatbot.backend.domain.user.entity.User;
import com.chatbot.backend.domain.user.repository.UserRepository;

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
	private final BoardValidator boardValidator;

	@Override
	public BoardDetailResponse createBoard(Long userId, BoardCreateRequest boardCreateRequest, MultipartFile file) {
		// 검증 & 조회
		User user = userRepository.findByIdOrElseThrow(userId);
		Category category = categoryRepository.findByNameOrElseThrow(boardCreateRequest.category());

		boardValidator.validateUserWriteAuthorized(user);

		// Board 생성 (비즈니스 로직)
		Board board = boardCreateRequest.toEntity(
			user,
			category,
			fileService.saveFile(file, BOARD_UPLOAD_DIR));

		return BoardDetailResponse.of(boardRepository.save(board));
	}

	@Override
	public BoardDetailResponse updateBoard(Long userId, Long boardId, BoardUpdateRequest boardUpdateRequest,
		MultipartFile file) {
		// 검증 & 조회
		User user = userRepository.findByIdOrElseThrow(userId);
		Category category = categoryRepository.findByNameOrElseThrow(boardUpdateRequest.category());
		Board board = boardRepository.findByIdOrElseThrow(boardId);

		boardValidator.validateBoardExists(board);
		boardValidator.validateUserAuthorization(user, board);

		// Board 수정 (비즈니스 로직)
		board.updateBoard(
			boardUpdateRequest,
			category,
			fileService.saveFile(file, BOARD_UPLOAD_DIR));

		BoardLike boardLike = boardLikeRepository.findByBoardIdAndUserId(boardId, userId).orElse(null);
		return BoardDetailResponse.of(board, boardLike);
	}

	@Override
	public void deleteBoard(Long userId, Long boardId) {
		// 검증 & 조회
		User user = userRepository.findByIdOrElseThrow(userId);
		Board board = boardRepository.findByIdOrElseThrow(boardId);

		boardValidator.validateBoardExists(board);
		boardValidator.validateUserAuthorization(user, board);

		board.deleteBoard();
	}

	@Override
	@Transactional(readOnly = true)
	public BoardDetailResponse getBoard(Long userId, Long boardId) {
		// 검증 & 조회
		User user = userRepository.findByIdOrElseThrow(userId);
		Board board = boardRepository.findByIdOrElseThrow(boardId);

		boardValidator.validateBoardExists(board);
		boardValidator.validateBoardAccess(user, board);

		BoardLike boardLike = boardLikeRepository.findByBoardIdAndUserId(boardId, userId).orElse(null);
		return BoardDetailResponse.of(board, boardLike);
	}
}