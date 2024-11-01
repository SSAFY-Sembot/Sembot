package com.chatbot.backend.domain.file.exception;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FileUploadFailedExceptionTest {

	@Test
	@DisplayName("예외 기본 생성자 Test")
	void constructorTest() {
		// given

		// when
		FileUploadFailedException fileUploadFailedException = new FileUploadFailedException();

		// then
		assertThat(fileUploadFailedException.getErrorCode()).isNotNull();
		assertThat(fileUploadFailedException.getMessage()).isNotEmpty();
	}

	@Test
	@DisplayName("예외 Cause를 포함한 생성자 Test")
	void constructorWithCauseTest() {
		// given
		Exception cause = new RuntimeException("Test Cause Exception");

		// when
		FileUploadFailedException fileUploadFailedException = new FileUploadFailedException(cause);

		// then
		assertThat(fileUploadFailedException.getErrorCode()).isNotNull();
		assertThat(fileUploadFailedException.getCause()).isEqualTo(cause);
	}
}
