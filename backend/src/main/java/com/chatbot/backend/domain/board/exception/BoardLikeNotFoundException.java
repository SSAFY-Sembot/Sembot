package com.chatbot.backend.domain.board.exception;

import com.chatbot.backend.global.error.ErrorCode;
import com.chatbot.backend.global.error.ServiceException;

public class BoardLikeNotFoundException extends ServiceException {
	private static final ErrorCode errorCode = ErrorCode.BOARD_LIKE_NOT_FOUND;

	public BoardLikeNotFoundException() {
		super(errorCode);
	}

	public BoardLikeNotFoundException(Exception exception) {
		super(errorCode, exception);
	}
}