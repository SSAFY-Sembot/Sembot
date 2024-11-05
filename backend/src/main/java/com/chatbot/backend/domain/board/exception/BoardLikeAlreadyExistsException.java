package com.chatbot.backend.domain.board.exception;

import com.chatbot.backend.global.error.ErrorCode;
import com.chatbot.backend.global.error.ServiceException;

public class BoardLikeAlreadyExistsException extends ServiceException {
	private static final ErrorCode errorCode = ErrorCode.BOARD_LIKE_ALREADY_EXISTS;

	public BoardLikeAlreadyExistsException() {
		super(errorCode);
	}

	public BoardLikeAlreadyExistsException(Exception exception) {
		super(errorCode, exception);
	}
}