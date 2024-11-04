package com.chatbot.backend.domain.board.exception;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BoardNotFoundExceptionTest {

	@Test
	@DisplayName("예외 기본 생성자 Test")
	void constructorTest() {
		// given

		// when
		BoardNotFoundException boardNotFoundException = new BoardNotFoundException();

		// then
		assertThat(boardNotFoundException.getErrorCode()).isNotNull();
		assertThat(boardNotFoundException.getMessage()).isNotEmpty();
	}

	@Test
	@DisplayName("예외 Cause를 포함한 생성자 Test")
	void constructorWithCauseTest() {
		// given
		Exception cause = new RuntimeException("Test Cause Exception");

		// when
		BoardNotFoundException boardNotFoundException = new BoardNotFoundException(cause);

		// then
		assertThat(boardNotFoundException.getErrorCode()).isNotNull();
		assertThat(boardNotFoundException.getCause()).isEqualTo(cause);
	}
}
