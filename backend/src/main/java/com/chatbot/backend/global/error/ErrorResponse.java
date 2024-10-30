package com.chatbot.backend.global.error;

public record ErrorResponse(
	int httpStatus,
	String message,
	String code,
	String detailMessage
) {
	// 생성자 오버로딩
	public ErrorResponse(ErrorCode errorCode, String detailMessage) {
		this(
			errorCode.getHttpStatus(),
			errorCode.getMessage(),
			errorCode.getCode(),
			detailMessage
		);
	}

	public ErrorResponse(ErrorCode errorCode) {
		this(
			errorCode.getHttpStatus(),
			errorCode.getMessage(),
			errorCode.getCode(),
			null
		);
	}
}