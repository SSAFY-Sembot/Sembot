package com.chatbot.backend.domain.admin.exception;

import com.chatbot.backend.global.error.ErrorCode;
import com.chatbot.backend.global.error.ServiceException;

public class NoAuthorityException extends ServiceException {
	private static final ErrorCode errorCode = ErrorCode.NO_AUTHORITY;

	public NoAuthorityException() {
		super(errorCode);
	}
}
