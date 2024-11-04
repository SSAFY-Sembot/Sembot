package com.chatbot.backend.domain.board.exception;

import com.chatbot.backend.global.error.ErrorCode;
import com.chatbot.backend.global.error.ServiceException;

public class BoardLevelInsufficientException extends ServiceException {
	private static final ErrorCode errorCode = ErrorCode.BOARD_LEVEL_INSUFFICIENT;

	public BoardLevelInsufficientException() {
		super(errorCode);
	}

	public BoardLevelInsufficientException(Exception exception) {
		super(errorCode, exception);
	}
}