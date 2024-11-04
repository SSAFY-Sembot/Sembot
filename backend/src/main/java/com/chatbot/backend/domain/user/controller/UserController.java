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
import com.chatbot.backend.domain.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;


	@PostMapping("/register")
	public ResponseEntity<Void> signUp(@Valid @RequestBody SignupRequestDto signupRequestDto){
		userService.signUp(signupRequestDto);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/login")
	public ResponseEntity<Void> login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response){
		userService.login(loginRequestDto, response);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/logout")
	public ResponseEntity<Void> logout(HttpServletRequest request, HttpServletResponse response){
		userService.logout( request, response);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity<Boolean> isDuplicate(@RequestParam("email") String email){
		userService.isDuplicate(email);
		return ResponseEntity.ok(false);
	}

	@PostMapping("/reissue")
	public ResponseEntity<?> reissue(HttpServletRequest request, HttpServletResponse response){
		userService.reissue(request, response);
		return ResponseEntity.ok().build();
	}
}
