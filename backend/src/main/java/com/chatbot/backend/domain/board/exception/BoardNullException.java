package com.chatbot.backend.domain.board.exception;

import com.chatbot.backend.global.error.ErrorCode;
import com.chatbot.backend.global.error.ServiceException;

public class BoardNullException extends ServiceException {
	private static final ErrorCode errorCode = ErrorCode.BOARD_NULL;

	public BoardNullException() {
		super(errorCode);
	}

	public BoardNullException(Exception exception) {
		super(errorCode, exception);
	}
}
