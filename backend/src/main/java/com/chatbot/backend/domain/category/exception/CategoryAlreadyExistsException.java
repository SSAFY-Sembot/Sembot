package com.chatbot.backend.domain.category.exception;

import com.chatbot.backend.global.error.ErrorCode;
import com.chatbot.backend.global.error.ServiceException;

public class CategoryAlreadyExistsException extends ServiceException {
	private static final ErrorCode errorCode = ErrorCode.CATEGORY_ALREADY_EXISTS;

	public CategoryAlreadyExistsException() {
		super(errorCode);
	}

	public CategoryAlreadyExistsException(Exception exception) {
		super(errorCode,exception);
	}
}
