package com.chatbot.backend.domain.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.chatbot.backend.domain.user.dto.request.LoginRequestDto;
import com.chatbot.backend.domain.user.dto.request.SignupRequestDto;
import com.chatbot.backend.domain.user.entity.User;
import com.chatbot.backend.domain.user.exception.DuplicateEmailException;
import com.chatbot.backend.domain.user.exception.NotLoginException;
import com.chatbot.backend.domain.user.repository.UserRepository;
import com.chatbot.backend.global.config.SecurityConfig;
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

	@Autowired
	private final PasswordEncoder passwordEncoder;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Override
	public void signUp(SignupRequestDto signupRequestDto) {
		// 이메일로 찾았는데
		Optional<User> signupUser = userRepository.findUserByEmail(signupRequestDto.getEmail());

		// 이미 있는 user면 던지기
		if(signupUser.isPresent()){
			throw new DuplicateEmailException();
		}

		// 없으면 encode 후 entity repo save
		String encodedPassword = passwordEncoder.encode(signupRequestDto.getPassword());
		User newUser = signupRequestDto.toEntity(encodedPassword);
		userRepository.save(newUser);
	}

	@Override
	public void login(LoginRequestDto loginRequestDto, HttpServletResponse response) {

		// 이메일로 찾았는데 없으면 던지기
		User loginUser = userRepository.findByEmailOrElseThrow(loginRequestDto.getEmail());

		// 패스워드 repo의 encoded 패스워드와 일치하지않으면 던지기
		if(!passwordEncoder.matches(loginRequestDto.getPassword(),loginUser.getPassword())){
			throw new NotLoginException();
		}

		// 새로운 accessToken과 refreshToken 생성
		Role role = loginUser.getRole();
		String accessToken = jwtProvider.createAccessToken(loginRequestDto.getEmail(), role);
		String refreshToken = jwtProvider.createRefreshToken(loginRequestDto.getEmail());

		// accessToken 헤더에 저장
		response.setHeader("accessToken","Bearer "+accessToken);

		// refreshToken 쿠키와 redis에 저장
		Cookie cookie = new Cookie("refreshToken",refreshToken);
		cookie.setPath("/");
		cookie.setMaxAge((int)refreshTokenExpiration/1000);
		cookie.setHttpOnly(true);
		response.addCookie(cookie);
		redisTemplate.opsForValue().set(loginUser.getEmail(),refreshToken);
	}

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		String rToken = null;

		// refreshToken 쿠키에서 가져오기 -> TODO : 없으면?
		if(cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("refreshToken")) {

					// refrshToken 쿠키에서 지우기
					c.setMaxAge(0);
					c.setPath("/");
					response.addCookie(c);
					rToken = c.getValue();
					break;
				}
			}
		}

		// refreshToken이 있을때만
		if(rToken != null){

			// refreshToken redis에서 지우고
			String userId = jwtProvider.parseClaims(rToken, true).getSubject();
			redisTemplate.delete(userId);

			// accessToken 헤더에서 지우기
			response.setHeader("accessToken",null);
		}

	}




	@Override
	public void reissue(HttpServletRequest request, HttpServletResponse response) {

		// refreshToken 가져와서
		Cookie[] cookies = request.getCookies();
		String rToken = null;
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("refreshToken")){
				rToken = cookie.getValue();
				break;
			}
		}


		// refreshToken 없다면 던지기
		if(rToken == null){
			throw new NoTokenException();
		}

		// refreshToken 있다면
		// 만료여부 확인
		jwtProvider.validateToken(rToken, true);

		// 새 accessToken, refreshToken 만들어서
		String userId = jwtProvider.parseClaims(rToken, true).getSubject();
		Role role = userRepository.findByEmailOrElseThrow(userId).getRole();
		String newAccessToken = jwtProvider.createAccessToken(userId, role);
		String newRefreshToken = jwtProvider.createRefreshToken(userId);

		// accessTokenn 헤더에 저장
		response.setHeader("accessToken","Bearer "+newAccessToken);

		// refreshToken 쿠키와 redis에 저장
		Cookie cookie = new Cookie("refreshToken",newRefreshToken);
		cookie.setPath("/");
		cookie.setMaxAge((int)refreshTokenExpiration/1000);
		cookie.setHttpOnly(true);
		User user = userRepository.findByEmailOrElseThrow(userId);
		redisTemplate.opsForValue().set(user.getEmail(),newRefreshToken);
	}

	@Override
	public void isDuplicate(String email) {
		User user = userRepository.findByEmailOrElseThrow(email);
		if(user != null){
			throw new DuplicateEmailException();
		}
	}
}
