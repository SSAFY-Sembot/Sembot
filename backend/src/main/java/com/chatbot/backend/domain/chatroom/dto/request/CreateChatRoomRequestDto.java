package com.chatbot.backend.domain.chatroom.dto.request;

import lombok.Getter;

@Getter
public class CreateChatRoomRequestDto {

    private Long memberId;
    private String content;
}
