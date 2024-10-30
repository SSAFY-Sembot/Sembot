package com.chatbot.backend.domain.chatroom.controller;


import com.chatbot.backend.domain.chatroom.dto.request.CreateChatRoomRequestDto;
import com.chatbot.backend.domain.chatroom.dto.response.CreateChatRoomResponseDto;
import com.chatbot.backend.domain.chatroom.service.ChatRoomServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chatrooms")
@RequiredArgsConstructor
public class ChatRoomController {

    private final ChatRoomServiceImpl chatRoomService;

    @PostMapping("")
    public ResponseEntity<CreateChatRoomResponseDto> createChatRoom(
           @RequestBody CreateChatRoomRequestDto createChatRoomRequestDto)
    {
        CreateChatRoomResponseDto response = chatRoomService.createChatRoom(createChatRoomRequestDto);
        return ResponseEntity.ok().body(response);
    }
}
