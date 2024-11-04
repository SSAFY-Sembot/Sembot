package com.chatbot.backend.domain.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chatbot.backend.domain.board.entity.Board;
import com.chatbot.backend.domain.board.exception.BoardNotFoundException;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
	default Board findByIdOrElseThrow(Long id) {
		return findById(id).orElseThrow(BoardNotFoundException::new);
	}
}
