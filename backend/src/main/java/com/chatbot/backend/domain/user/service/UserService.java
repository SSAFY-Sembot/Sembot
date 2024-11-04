package com.chatbot.backend.domain.user.service;

import com.chatbot.backend.domain.user.dto.request.LoginRequestDto;
import com.chatbot.backend.domain.user.dto.request.SignupRequestDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface UserService {
	void signUp(SignupRequestDto signupRequestDto);
	void login(LoginRequestDto loginRequestDto, HttpServletResponse response);
	void logout(HttpServletRequest request, HttpServletResponse response);
	void isDuplicate(String email);
	void reissue(HttpServletRequest request, HttpServletResponse response);
}
