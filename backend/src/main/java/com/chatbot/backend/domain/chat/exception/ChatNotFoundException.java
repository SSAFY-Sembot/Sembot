package com.chatbot.backend.domain.chat.exception;

import com.chatbot.backend.global.error.ErrorCode;
import com.chatbot.backend.global.error.ServiceException;

public class ChatNotFoundException extends ServiceException {
	private static final ErrorCode errorCode = ErrorCode.CHAT_NOT_FOUND;

	public ChatNotFoundException() {
		super(errorCode);
	}

	public ChatNotFoundException(Exception exception) {
		super(errorCode, exception);
	}
}
