package com.chatbot.backend.domain.file.exception;

import com.chatbot.backend.global.error.ErrorCode;
import com.chatbot.backend.global.error.ServiceException;

public class FileDirectoryInvalidException extends ServiceException {
	private static final ErrorCode errorCode = ErrorCode.FILE_DIRECTORY_INVALID;

	public FileDirectoryInvalidException() {
		super(errorCode);
	}

	public FileDirectoryInvalidException(Exception exception) {
		super(errorCode, exception);
	}
}