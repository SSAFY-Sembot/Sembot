package com.chatbot.backend.global.jwt.exception;

import com.chatbot.backend.global.error.ErrorCode;
import com.chatbot.backend.global.error.ServiceException;

// 유효하지 않은 JWT 토큰 예외를 처리하는 클래스
public class InvalidTokenException extends ServiceException {
	private static final ErrorCode errorCode = ErrorCode.INVALID_TOKEN;

	public InvalidTokenException() {
		super(errorCode);
	}

	public InvalidTokenException(Exception exception) {
		super(errorCode, exception);
	}
}