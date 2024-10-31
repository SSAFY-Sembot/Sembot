package com.chatbot.backend.domain.chatroom.entity;


import com.chatbot.backend.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "chatrooms")
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

    @ColumnDefault("false")
    private boolean isDeleted;

    @Builder
    public ChatRoom(User user, String content){
        this.user = user;
        this.title = content.substring(0, 8);
        this.createdAt = LocalDateTime.now();
    }


}
