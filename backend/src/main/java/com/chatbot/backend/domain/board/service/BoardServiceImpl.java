package com.chatbot.backend.domain.board.service;

import org.springframework.stereotype.Service;

import com.chatbot.backend.domain.board.dto.request.CreateBoardRequest;
import com.chatbot.backend.domain.board.entity.Board;
import com.chatbot.backend.domain.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	private final BoardRepository boardRepository;

	@Override
	public void createBoard(CreateBoardRequest createBoardRequest) {
		boardRepository.save(
			Board.builder()
				.title(createBoardRequest.getTitle())
				.category(createBoardRequest.getCategory())
				.content(createBoardRequest.getContent())
				.ruleURL(createBoardRequest.getRuleURL())
				.level(createBoardRequest.getLevel())
				.build()
		);
	}
}
