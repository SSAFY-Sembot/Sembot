package com.chatbot.backend.domain.user.dto.request;

import lombok.Data;

@Data
public class SignupRequestDto {

	private String email;
	private String password;
	private String name;
	private String employeeNum;
	private String department;
	private String profileUrl;
}
