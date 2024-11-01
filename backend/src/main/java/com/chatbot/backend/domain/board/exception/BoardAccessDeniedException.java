package com.chatbot.backend.domain.board.exception;

import com.chatbot.backend.global.error.ErrorCode;
import com.chatbot.backend.global.error.ServiceException;

public class BoardAccessDeniedException extends ServiceException {
	private static final ErrorCode errorCode = ErrorCode.BOARD_ACCESS_DENIED;

	public BoardAccessDeniedException() {
		super(errorCode);
	}

	public BoardAccessDeniedException(Exception exception) {
		super(errorCode, exception);
	}
}