package com.chatbot.backend.global.file.exception;

import com.chatbot.backend.global.error.ErrorCode;
import com.chatbot.backend.global.error.ServiceException;

public class FileUploadFailedException extends ServiceException {
	private static final ErrorCode errorCode = ErrorCode.FILE_UPLOAD_FAILED;

	public FileUploadFailedException() {
		super(errorCode);
	}

	public FileUploadFailedException(Exception exception) {
		super(errorCode, exception);
	}
}