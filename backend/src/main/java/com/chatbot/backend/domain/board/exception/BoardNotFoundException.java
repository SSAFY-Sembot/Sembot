package com.chatbot.backend.domain.board.exception;

import com.chatbot.backend.global.error.ErrorCode;
import com.chatbot.backend.global.error.ServiceException;

public class BoardNotFoundException extends ServiceException {
	private static final ErrorCode errorCode = ErrorCode.BOARD_NOT_FOUND;

	public BoardNotFoundException() {
		super(errorCode);
	}

	public BoardNotFoundException(Exception exception) {
		super(errorCode, exception);
	}
}