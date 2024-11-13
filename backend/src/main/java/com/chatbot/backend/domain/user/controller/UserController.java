package com.chatbot.backend.domain.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chatbot.backend.domain.user.dto.request.LoginRequestDto;
import com.chatbot.backend.domain.user.dto.request.SignupRequestDto;
import com.chatbot.backend.domain.user.dto.response.LoginResponseDto;
import com.chatbot.backend.domain.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

	private final UserService userService;

	@PostMapping("/register")
	public ResponseEntity<Void> signUp(@Valid @RequestBody SignupRequestDto signupRequestDto) {
		userService.signUp(signupRequestDto);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto,
		HttpServletResponse response) {
		return ResponseEntity.ok().body(userService.login(loginRequestDto, response));
	}

	@PostMapping("/logout")
	public ResponseEntity<Void> logout(HttpServletRequest request, HttpServletResponse response) {
		userService.logout(request, response);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity<Boolean> isDuplicate(@RequestParam("email") String email) {

		return ResponseEntity.ok().body(userService.isDuplicate(email));
	}

	@PostMapping("/reissue")
	public ResponseEntity<?> reissue(HttpServletRequest request, HttpServletResponse response) {
		userService.reissue(request, response);
		return ResponseEntity.ok().build();
	}
}
