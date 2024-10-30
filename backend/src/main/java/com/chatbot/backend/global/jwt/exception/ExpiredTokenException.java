package com.chatbot.backend.global.jwt.exception;

import com.chatbot.backend.global.error.ErrorCode;
import com.chatbot.backend.global.error.ServiceException;

public class ExpiredTokenException extends ServiceException {
	private static final ErrorCode errorCode = ErrorCode.EXPIRED_TOKEN;

	public ExpiredTokenException() {
		super(errorCode);
	}

	public ExpiredTokenException(Exception exception) {
		super(errorCode, exception);
	}
}