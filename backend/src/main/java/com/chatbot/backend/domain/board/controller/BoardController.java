package com.chatbot.backend.domain.board.controller;


import com.chatbot.backend.domain.board.dto.request.CreateBoardRequestDto;
import com.chatbot.backend.domain.board.dto.response.CreateBoardResponseDto;
import com.chatbot.backend.domain.board.service.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/")
@RequiredArgsConstructor
public class BoardController {

    private final BoardServiceImpl boardService;

    @PostMapping("/board")
    ResponseEntity<?> createBoard(
            CreateBoardRequestDto createBoardRequestDto){
        boardService.createBoard(createBoardRequestDto);

        return ResponseEntity.ok().build();
    }
}
