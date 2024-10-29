package com.chatbot.backend.domain.chatroom.entity;


import com.chatbot.backend.domain.user.entity.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ChatRoom {

    @Id
    @GeneratedValue
    @Column(name = "CHATROOM_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    private String title;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

}
