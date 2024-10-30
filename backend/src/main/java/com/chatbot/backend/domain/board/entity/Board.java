package com.chatbot.backend.domain.board.entity;

import com.chatbot.backend.global.shared.BaseTimeEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseTimeEntity {

	@Id
	private Long id;

	private String title;
	private String content;
	private int level;
	private String category;
	private String ruleURL;

	@Builder
	public Board(String title, String content, int level, String category, String ruleURL) {
		this.title = title;
		this.content = content;
		this.category = category;
		this.level = level;
		this.ruleURL = ruleURL;
	}
}