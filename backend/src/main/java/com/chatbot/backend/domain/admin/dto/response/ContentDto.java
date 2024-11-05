package com.chatbot.backend.domain.admin.dto.response;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ContentDto{
	private String chatId;
	private String question;
	private String answer;
	private Boolean isPositive;
	private String negativeReason;
	private LocalDateTime createdAt;

}
