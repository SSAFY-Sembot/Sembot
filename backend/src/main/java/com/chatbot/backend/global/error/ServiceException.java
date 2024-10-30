package com.chatbot.backend.global.error;

import lombok.Getter;

// 서비스 계층에서 사용되는 사용자 정의 예외 클래스
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
