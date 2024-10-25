package com.chatbot.backend.domain.board.service;

import com.chatbot.backend.domain.board.dto.request.CreateBoardRequestDto;

public interface BoardService {

    void createBoard(CreateBoardRequestDto createBoardRequestDto);
}
