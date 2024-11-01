package com.chatbot.backend.domain.user.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.chatbot.backend.domain.user.dto.request.LoginRequestDto;
import com.chatbot.backend.domain.user.dto.request.SignupRequestDto;
import com.chatbot.backend.domain.user.entity.User;
import com.chatbot.backend.domain.user.exception.DuplicateEmailException;
import com.chatbot.backend.domain.user.exception.NotLoginException;
import com.chatbot.backend.domain.user.repository.UserRepository;
import com.chatbot.backend.global.jwt.JwtProvider;
import com.chatbot.backend.global.jwt.Role;
import com.chatbot.backend.global.jwt.exception.NoTokenException;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;
	private final JwtProvider jwtProvider;
	@Value("${jwt.refresh_token_expiration}")
	private long refreshTokenExpiration;

	@Override
	public void signUp(SignupRequestDto signupRequestDto) {
		log.info("signupRequestDto : {}", signupRequestDto);
		User signupUser = userRepository.findUserByEmail(signupRequestDto.getEmail());
		log.info("Signup User : {}", signupUser);
		if(signupUser != null){
			throw new DuplicateEmailException();
		}

		User newUser = User.builder()
			.email(signupRequestDto.getEmail())
			.password(signupRequestDto.getPassword())
			.department(signupRequestDto.getDepartment())
			.employeeNum(signupRequestDto.getEmployeeNum())
			.name(signupRequestDto.getName())
			.profileUrl(signupRequestDto.getProfileUrl())
			.role(signupRequestDto.getDepartment().equals("인사과") ? Role.USER_WRITE : Role.USER)
			.canCreateBoard(signupRequestDto.getDepartment().equals("인사과"))
			.isDeleted(false)
			.level(1)
			.build();

		userRepository.save(newUser);
	}

	@Override
	public void login(LoginRequestDto loginRequestDto, HttpServletResponse response) {

		User loginUser = userRepository.findUserByEmail(loginRequestDto.getEmail());
		if(loginUser == null || !loginUser.getPassword().equals(loginRequestDto.getPassword())){
			log.info("request : {} in DB : {} {}", loginRequestDto, loginUser.getEmail(), loginUser.getPassword());
			throw new NotLoginException();
		}

		Role role = getRole(loginRequestDto.getEmail());

		String accessToken = jwtProvider.createAccessToken(loginRequestDto.getEmail(), role);
		String refreshToken = jwtProvider.createRefreshToken(loginRequestDto.getEmail());

		response.setHeader("accessToken","Bearer "+accessToken);

		Cookie cookie = new Cookie("refreshToken",refreshToken);
		cookie.setPath("/");
		cookie.setMaxAge((int)refreshTokenExpiration/1000);
		cookie.setHttpOnly(true);
		response.addCookie(cookie);
	}

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("refreshToken")) {
					c.setMaxAge(0);
					c.setPath("/");
					response.addCookie(c);
					break;
				}
			}
		}

		// TODO : redis에서 삭제
		response.setHeader("accessToken",null);
	}

	@Override
	public void isDuplicate(String email) {
		User user = userRepository.findUserByEmail(email);
		if(user != null){
			throw new DuplicateEmailException();
		}
	}

	@Override
	public Role getRole(String email) {
		return userRepository.findUserByEmail(email).getRole();
	}

	@Override
	public void reissue(HttpServletRequest request, HttpServletResponse response) {
		String refresh = null;
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("refreshToken")){
				refresh = cookie.getValue();
				break;
			}
		}


		// refresh가 없다면
		if(refresh == null){
			throw new NoTokenException();
		}

		// refresh가 있다면
		// 만료여부 확인
		jwtProvider.validateToken(refresh, true);


		String userId = jwtProvider.parseClaims(refresh, true).getSubject();
		Role role = getRole(userId);

		String newAccessToken = jwtProvider.createAccessToken(userId, role);
		String newRefreshToken = jwtProvider.createRefreshToken(userId);

		response.setHeader("accessToken","Bearer "+newAccessToken);

		Cookie cookie = new Cookie("refreshToken",newRefreshToken);
		cookie.setPath("/");
		cookie.setMaxAge((int)refreshTokenExpiration/1000);
		cookie.setHttpOnly(true);

		// TODO : Redis에 refreshToken 저장하기 ^^
	}
}
