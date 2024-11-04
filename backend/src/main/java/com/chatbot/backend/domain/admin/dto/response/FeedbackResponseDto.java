package com.chatbot.backend.domain.admin.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FeedbackResponseDto {
	private List<Content> contents;
	

	// 지환님 채팅 피드백 저장한거 가져와야돼서 기다려야할듯?

	static class Content{
		private String chatId;
		private String question;
		private String answer;
		private LocalDateTime createdAt;

		static class FeedbackInfo{
			private Boolean isPositive;
			private String negativeReason;
			// private LocalDateTime
		}
	}
}

