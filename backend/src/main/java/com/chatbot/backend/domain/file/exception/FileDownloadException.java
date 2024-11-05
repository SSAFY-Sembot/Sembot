package com.chatbot.backend.domain.file.exception;

import com.chatbot.backend.global.error.ErrorCode;
import com.chatbot.backend.global.error.ServiceException;

public class FileDownloadException extends ServiceException {
	private static final ErrorCode errorCode = ErrorCode.FILE_DOWNLOAD_FAILED;

	public FileDownloadException() {
		super(errorCode);
	}

	public FileDownloadException(Exception exception) {
		super(errorCode, exception);
	}
}