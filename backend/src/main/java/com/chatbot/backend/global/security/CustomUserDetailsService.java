package com.chatbot.backend.global.security;

import org.springframework.stereotype.Service;

import com.chatbot.backend.domain.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService {

	private final UserRepository userRepository;
}
