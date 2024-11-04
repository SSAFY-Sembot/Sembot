package com.chatbot.backend.domain.chat.entitiy;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Document(collation = "chatfeedbacks")
public class ChatFeedBack {

	@Id
	@GeneratedValue
	
}
