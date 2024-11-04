package com.chatbot.backend.domain.user.dto.request;

import lombok.Data;

@Data
public class LoginRequestDto {
	private String email;
	private String password;
}
