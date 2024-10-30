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

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	private final JwtProvider jwtProvider;

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.cors(corsConfig ->
				corsConfig.disable())
			.csrf(csrfConfig ->
				csrfConfig.disable())
			.formLogin(formLoginConfig ->
				formLoginConfig.disable())
			.httpBasic(httpBasicConfig ->
				httpBasicConfig.disable())
			.sessionManagement(sessionManagement ->
				sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authorizeHttpRequests(authorizeRequests ->
				authorizeRequests
					.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
					.requestMatchers(CorsUtils::isCorsRequest).permitAll()
					.requestMatchers("/v3/api-docs/**", "/swagger-ui/**").permitAll()
					// 미인증 사용자 접근 허용
					.requestMatchers("/", "/login", "/register").permitAll()
					// ADMIN 권한 설정
					.requestMatchers("/admin/**").hasRole(Role.ADMIN.getKey())
					// ADMIN과 USER 모두 접근 가능
					.requestMatchers("/board/**").hasAnyRole(Role.ADMIN.getKey(), Role.USER.getKey())
					// USER 권한 설정
					.requestMatchers("/chat/**").hasRole(Role.USER.getKey())
					.anyRequest().authenticated()
			)
			.addFilterBefore(new JwtFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}