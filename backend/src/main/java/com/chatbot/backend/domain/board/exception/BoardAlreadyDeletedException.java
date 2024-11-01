package com.chatbot.backend.domain.board.exception;

import com.chatbot.backend.global.error.ErrorCode;
import com.chatbot.backend.global.error.ServiceException;

public class BoardAlreadyDeletedException extends ServiceException {
	private static final ErrorCode errorCode = ErrorCode.BOARD_ALREADY_DELETED;

	public BoardAlreadyDeletedException() {
		super(errorCode);
	}

	public BoardAlreadyDeletedException(Exception exception) {
		super(errorCode, exception);
	}
}