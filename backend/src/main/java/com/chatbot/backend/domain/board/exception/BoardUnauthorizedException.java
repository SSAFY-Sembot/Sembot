package com.chatbot.backend.domain.board.exception;

import com.chatbot.backend.global.error.ErrorCode;
import com.chatbot.backend.global.error.ServiceException;

public class BoardUnauthorizedException extends ServiceException {
	private static final ErrorCode errorCode = ErrorCode.BOARD_MODIFY_UNAUTHORIZED;

	public BoardUnauthorizedException() {
		super(errorCode);
	}

	public BoardUnauthorizedException(Exception exception) {
		super(errorCode, exception);
	}
}