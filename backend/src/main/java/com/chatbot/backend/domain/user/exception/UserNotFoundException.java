package com.chatbot.backend.domain.user.exception;

import com.chatbot.backend.global.error.ErrorCode;
import com.chatbot.backend.global.error.ServiceException;

public class UserNotFoundException extends ServiceException {
	private static final ErrorCode errorCode = ErrorCode.USER_NOT_FOUND;

	public UserNotFoundException() {
		super(errorCode);
	}

	public UserNotFoundException(Exception exception) {
		super(errorCode, exception);
	}
}