package com.chatbot.backend.domain.chatroom.controller;


import com.chatbot.backend.domain.chatroom.dto.request.CreateChatRoomRequestDto;
import com.chatbot.backend.domain.chatroom.dto.request.FindChatRoomListRequestDto;
import com.chatbot.backend.domain.chatroom.dto.response.CreateChatRoomResponseDto;
import com.chatbot.backend.domain.chatroom.dto.response.FindChatRoomListResponseDto;
import com.chatbot.backend.domain.chatroom.service.ChatRoomServiceImpl;
import com.chatbot.backend.global.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/chatrooms")
@RequiredArgsConstructor
public class ChatRoomController {

    private final ChatRoomServiceImpl chatRoomService;

    @PostMapping("")
    public ResponseEntity<CreateChatRoomResponseDto> createChatRoom(
            @AuthenticationPrincipal CustomUserDetails userDetails,
           @RequestBody CreateChatRoomRequestDto createChatRoomRequestDto)
    {
        createChatRoomRequestDto.setUserId(userDetails.getId());
        CreateChatRoomResponseDto response = chatRoomService.createChatRoom(createChatRoomRequestDto);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("")
    public ResponseEntity<FindChatRoomListResponseDto> findChatRoomList(
            @RequestBody FindChatRoomListRequestDto findChatRoomListRequestDto
            ){
        FindChatRoomListResponseDto response = chatRoomService.findChatRoomList(findChatRoomListRequestDto);
        return ResponseEntity.ok().body(response);
    }
}
