package com.chatbot.backend.domain.board.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chatbot.backend.domain.board.dto.request.CreateBoardRequest;
import com.chatbot.backend.domain.board.entity.Board;
import com.chatbot.backend.domain.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardServiceImpl implements BoardService {
	private final BoardRepository boardRepository;

	@Override
	public void createBoard(CreateBoardRequest createBoardRequest) {
		boardRepository.save(
			Board.builder()
				.title(createBoardRequest.getTitle())
				.contents(createBoardRequest.getContents())
				.fileUrl(createBoardRequest.getFileUrl())
				.level(createBoardRequest.getLevel())
				.build()
		);
	}
}
