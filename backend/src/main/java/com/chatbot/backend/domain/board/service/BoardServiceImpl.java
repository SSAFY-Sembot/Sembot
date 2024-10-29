package com.chatbot.backend.domain.board.service;


import com.chatbot.backend.domain.board.dto.request.CreateBoardRequestDto;
import com.chatbot.backend.domain.board.entity.Board;
import com.chatbot.backend.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    @Override
    public void createBoard(CreateBoardRequestDto createBoardRequestDto) {

        boardRepository.save(
                Board.builder()
                        .title(createBoardRequestDto.getTitle())
                        .category(createBoardRequestDto.getCategory())
                        .content(createBoardRequestDto.getContent())
                        .ruleURL(createBoardRequestDto.getRuleURL())
                        .level(createBoardRequestDto.getLevel())
                        .build()
        );
    }
}
