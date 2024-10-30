package com.chatbot.backend.domain.chatroom.service;


import com.chatbot.backend.domain.chatroom.dto.request.CreateChatRoomRequestDto;
import com.chatbot.backend.domain.chatroom.dto.request.DeleteChatRoomRequestDto;
import com.chatbot.backend.domain.chatroom.dto.request.FindChatRoomDetailRequestDto;
import com.chatbot.backend.domain.chatroom.dto.request.FindChatRoomListRequestDto;
import com.chatbot.backend.domain.chatroom.dto.response.CreateChatRoomResponseDto;
import com.chatbot.backend.domain.chatroom.dto.response.DeleteChatRoomResponseDto;
import com.chatbot.backend.domain.chatroom.dto.response.FindChatRoomDetailResponseDto;
import com.chatbot.backend.domain.chatroom.dto.response.FindChatRoomListResponseDto;
import com.chatbot.backend.domain.chatroom.entity.ChatRoom;
import com.chatbot.backend.domain.chatroom.repository.ChatRoomRepository;
import com.chatbot.backend.domain.user.entity.User;
import com.chatbot.backend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatRoomServiceImpl implements ChatRoomService{

    private final ChatRoomRepository chatRoomRepository;
    private final UserRepository userRepository;

    @Override
    public CreateChatRoomResponseDto createChatRoom(CreateChatRoomRequestDto createChatRoomRequestDto) {

        User user = userRepository.findUserById(createChatRoomRequestDto.getMemberId());

        ChatRoom chatroom = chatRoomRepository.save(
                ChatRoom.builder()
                        .user(user)
                        .content(createChatRoomRequestDto.getContent())
                        .build());
        
        return new CreateChatRoomResponseDto(chatroom.getId(), chatroom.getTitle());
    }

    @Override
    public FindChatRoomListResponseDto findChatRoomList(FindChatRoomListRequestDto findChatRoomRequestDto) {
        return null;
    }

    @Override
    public FindChatRoomDetailResponseDto findChatRoomDetail(FindChatRoomDetailRequestDto findChatRoomDetailRequestDto) {
        return null;
    }

    @Override
    public DeleteChatRoomResponseDto deleteChatRoom(DeleteChatRoomRequestDto deleteChatRoomRequestDto) {
        return null;
    }
}
