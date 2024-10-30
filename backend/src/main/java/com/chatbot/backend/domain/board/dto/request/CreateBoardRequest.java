package com.chatbot.backend.domain.board.dto.request;

import lombok.Data;

@Data
public class CreateBoardRequest {
	private String title;
	private String category;
	private String content;
	private int level;
	private String ruleURL;
}