package com.chatbot.backend.global.jwt.exception;

import com.chatbot.backend.global.error.ErrorCode;
import com.chatbot.backend.global.error.ServiceException;

// JWT 토큰 만료 예외를 처리하는 클래스
public class ExpiredTokenException extends ServiceException {
	private static final ErrorCode errorCode = ErrorCode.EXPIRED_TOKEN;

	public ExpiredTokenException() {
		super(errorCode);
	}

	public ExpiredTokenException(Exception exception) {
		super(errorCode, exception);
	}
}