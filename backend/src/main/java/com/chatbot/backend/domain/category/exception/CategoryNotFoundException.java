package com.chatbot.backend.domain.category.exception;

import com.chatbot.backend.global.error.ErrorCode;
import com.chatbot.backend.global.error.ServiceException;

public class CategoryNotFoundException extends ServiceException {
	private static final ErrorCode errorCode = ErrorCode.CATEGORY_NOT_FOUND;

	public CategoryNotFoundException() {
		super(errorCode);
	}

	public CategoryNotFoundException(Exception exception) {
		super(errorCode, exception);
	}
}