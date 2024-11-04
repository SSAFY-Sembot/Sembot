package com.chatbot.backend.domain.user.exception;

import com.chatbot.backend.global.error.ErrorCode;
import com.chatbot.backend.global.error.ServiceException;

public class NotLoginException extends ServiceException {
	private static final ErrorCode errorCode = ErrorCode.INCORRECT_ID_OR_PASSWORD;

	public NotLoginException(){super(errorCode);}

	public NotLoginException(Exception exception) {
		super(errorCode,exception);
	}
}
