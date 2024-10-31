package com.chatbot.backend.domain.board.entity;

import com.chatbot.backend.global.shared.BaseTimeEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "board_id")
	private Long id;

	private String title;
	private String contents;
	private Integer level;
	private String fileUrl;
	private Boolean isDeleted;

	@Builder
	public Board(String title, String contents, int level, String fileUrl, Boolean isDeleted) {
		this.title = title;
		this.contents = contents;
		this.level = level;
		this.fileUrl = fileUrl;
		this.isDeleted = isDeleted == null ? false : isDeleted;
	}
}