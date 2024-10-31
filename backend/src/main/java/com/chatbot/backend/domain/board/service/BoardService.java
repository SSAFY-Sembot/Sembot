package com.chatbot.backend.domain.board.service;

import com.chatbot.backend.domain.board.dto.request.CreateBoardRequest;

public interface BoardService {
	void createBoard(CreateBoardRequest createBoardRequest);
}