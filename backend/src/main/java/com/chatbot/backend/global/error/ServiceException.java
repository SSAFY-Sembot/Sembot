package com.chatbot.backend.global.error;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {
	private final ErrorCode errorCode;

	public ServiceException(ErrorCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}

	public ServiceException(ErrorCode errorCode, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
	}
}
