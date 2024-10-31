package com.chatbot.backend.global.error;

// 에러 응답을 위한 레코드 클래스
// record를 사용하여 불변 객체로 생성
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