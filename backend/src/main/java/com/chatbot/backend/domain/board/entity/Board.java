package com.chatbot.backend.domain.board.entity;

import com.chatbot.backend.domain.board.dto.request.BoardUpdateRequest;
import com.chatbot.backend.domain.category.entity.Category;
import com.chatbot.backend.domain.user.entity.User;
import com.chatbot.backend.global.shared.BaseTimeEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "Boards")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "board_id")
	private Long id;

	@Column(nullable = false, length = 200)
	private String title;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String contents;

	@Column(nullable = false)
	private Integer level;

	private String fileUrl;

	@Column(nullable = false)
	private Boolean isDeleted;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	@Builder
	public Board(String title, String contents, int level, String fileUrl, Boolean isDeleted, User user,
		Category category) {
		this.title = title;
		this.contents = contents;
		this.level = level;
		this.fileUrl = fileUrl == null ? null : fileUrl;
		this.isDeleted = isDeleted == null ? false : isDeleted;
		this.user = user;
		this.category = category;
	}

	// Board File 업로드
	public void uploadFile(String fileUrl) {
		if (fileUrl != null) {
			this.fileUrl = fileUrl;
		}
	}

	// Board 정보 수정
	public void updateBoard(BoardUpdateRequest boardUpdateRequest, Category category, String fileUrl) {
		this.title = boardUpdateRequest.title();
		this.contents = boardUpdateRequest.contents();
		this.level = boardUpdateRequest.level();
		this.category = category;
		this.fileUrl = fileUrl;
	}

	// Board 삭제
	public void deleteBoard() {
		this.isDeleted = true;
	}
}