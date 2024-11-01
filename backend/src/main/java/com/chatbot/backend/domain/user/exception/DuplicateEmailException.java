package com.chatbot.backend.domain.user.exception;

import com.chatbot.backend.global.error.ErrorCode;
import com.chatbot.backend.global.error.ServiceException;

public class DuplicateEmailException extends ServiceException {
    private static final ErrorCode errorCode = ErrorCode.DUPLICATE_EMAIL;

    public DuplicateEmailException(){super(errorCode);}

	public DuplicateEmailException(Exception exception) {
		super(errorCode,exception);
	}
}
