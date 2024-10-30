package com.chatbot.backend.global.jwt.exception;

import com.chatbot.backend.global.error.ErrorCode;
import com.chatbot.backend.global.error.ServiceException;

public class InvalidTokenException extends ServiceException {
	private static final ErrorCode errorCode = ErrorCode.INVALID_TOKEN;

	public InvalidTokenException() {
		super(errorCode);
	}

	public InvalidTokenException(Exception exception) {
		super(errorCode, exception);
	}
}