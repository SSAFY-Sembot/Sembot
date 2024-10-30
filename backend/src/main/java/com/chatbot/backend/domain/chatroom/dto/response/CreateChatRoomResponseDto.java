package com.chatbot.backend.domain.chatroom.dto.response;

public class CreateChatRoomResponseDto {

    private Long chatRoomId;
    private String title;


    public CreateChatRoomResponseDto(Long chatRoomId, String title){
        this.chatRoomId = chatRoomId;
        this.title = title;
    }
}
