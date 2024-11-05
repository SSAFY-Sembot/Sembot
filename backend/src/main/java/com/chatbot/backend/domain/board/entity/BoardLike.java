package com.chatbot.backend.domain.board.entity;

import java.time.LocalDateTime;

import com.chatbot.backend.domain.board.exception.BoardNullException;
import com.chatbot.backend.domain.user.entity.User;
import com.chatbot.backend.domain.user.exception.UserNotFoundException;

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

@Table(name = "BoardLikes")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardLike {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "board_like_id")
	private Long id;

	private LocalDateTime createdAt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "board_id", nullable = false)
	private Board board;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Builder
	public BoardLike(Board board, User user) {
		validateBoardAndUser(board, user);
		this.createdAt = LocalDateTime.now();
		this.board = board;
		this.user = user;
	}

	// 게시글과 사용자 유효성 검사
	private void validateBoardAndUser(Board board, User user) {
		if (board == null) {
			throw new BoardNullException();
		}
		if (user == null) {
			throw new UserNotFoundException();
		}
	}
}