package com.chatbot.backend.global.jwt.exception;

import com.chatbot.backend.global.error.ErrorCode;
import com.chatbot.backend.global.error.ServiceException;

public class NoTokenException extends ServiceException {
	private static final ErrorCode errorCode = ErrorCode.NO_REFRESH_TOKEN;

	public NoTokenException() {
		super(errorCode);
	}

	public NoTokenException(Exception exception){super(errorCode, exception);}
}
