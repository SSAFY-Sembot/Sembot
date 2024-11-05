package com.chatbot.backend.domain.file.exception;

import com.chatbot.backend.global.error.ErrorCode;
import com.chatbot.backend.global.error.ServiceException;

public class FileNotFoundException extends ServiceException {
	private static final ErrorCode errorCode = ErrorCode.FILE_NOT_FOUND;

	public FileNotFoundException() {
		super(errorCode);
	}

	public FileNotFoundException(Exception exception) {
		super(errorCode, exception);
	}
}