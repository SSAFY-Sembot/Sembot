package com.chatbot.backend.domain.chat.entitiy;


import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "chatfeedbacks")
public class ChatFeedBack {

    private Long chatFeedBackId;


    @OneToOne(fetch = FetchType.LAZY)
    private Chat chat;
}
