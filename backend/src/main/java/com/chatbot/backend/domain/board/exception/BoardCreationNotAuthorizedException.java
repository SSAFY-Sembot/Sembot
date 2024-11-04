package com.chatbot.backend.domain.board.exception;

import com.chatbot.backend.global.error.ErrorCode;
import com.chatbot.backend.global.error.ServiceException;

public class BoardCreationNotAuthorizedException extends ServiceException {
	private static final ErrorCode errorCode = ErrorCode.BOARD_CREATION_NOT_AUTHORIZED;

	public BoardCreationNotAuthorizedException() {
		super(errorCode);
	}

	public BoardCreationNotAuthorizedException(Exception exception) {
		super(errorCode, exception);
	}
}