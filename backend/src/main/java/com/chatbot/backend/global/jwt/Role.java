package com.chatbot.backend.global.jwt;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

// 사용자 권한을 정의하는 열거형 클래스
@Getter
@RequiredArgsConstructor
public enum Role {
	USER("USER", "일반 사용자"),
	USER_WRITE("USER_WRITE", "일반 사용자 작성자"),
	ADMIN("ADMIN", "관리자");

	private final String key;
	private final String role;
}