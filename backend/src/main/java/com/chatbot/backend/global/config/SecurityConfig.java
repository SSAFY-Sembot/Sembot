package com.chatbot.backend.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

import com.chatbot.backend.global.jwt.JwtFilter;
import com.chatbot.backend.global.jwt.JwtProvider;
import com.chatbot.backend.global.jwt.Role;

import lombok.RequiredArgsConstructor;

// Spring Security 설정을 담당
@RequiredArgsConstructor
@Configuration
@EnableWebSecurity    // Spring Security 활성화
@EnableMethodSecurity
public class SecurityConfig {
	private final JwtProvider jwtProvider;

	// 비밀번호 암호화
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// Security 필터 체인 구성
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.cors(corsConfig ->
				corsConfig.disable())    // CORS 설정 비활성화 (CorsConfig에서 처리)
			.csrf(csrfConfig ->
				csrfConfig.disable())    // CSRF 보호 비활성화
			.formLogin(formLoginConfig ->
				formLoginConfig.disable())    // 폼 로그인 비활성화
			.httpBasic(httpBasicConfig ->
				httpBasicConfig.disable())    // HTTP Basic 인증 비활성화
			.sessionManagement(sessionManagement ->
				sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))    // 세션 사용하지 않음
			.authorizeHttpRequests(authorizeRequests ->
				authorizeRequests
					// URL 별 접근 권한 설정
					.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
					.requestMatchers(CorsUtils::isCorsRequest).permitAll()
					.requestMatchers("/v3/api-docs/**", "/swagger-ui/**").permitAll()    // Swagger 문서 접근 허용
					// 미인증 사용자 접근 허용
					.requestMatchers("/", "/login", "/register","/**").permitAll()
					// ADMIN 권한 설정
					// .requestMatchers("/admin/**").hasRole(Role.ADMIN.getKey())
					// // ADMIN과 USER 모두 접근 가능
					// .requestMatchers("/board/**").hasAnyRole(Role.ADMIN.getKey(), Role.USER.getKey())
					// // USER 권한 설정
					// .requestMatchers("/chat/**").hasRole(Role.USER.getKey())
					// // 그 외 모든 요청은 인증 필요
					// .anyRequest().authenticated()
			)
			// JWT 필터 추가
			.addFilterBefore(new JwtFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}