package com.chatbot.backend.global.jwt;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.chatbot.backend.global.jwt.exception.ExpiredTokenException;
import com.chatbot.backend.global.jwt.exception.InvalidTokenException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;

// Authorization 헤더에서 토큰 추출
@Slf4j
@Component
public class JwtProvider {
	private static final String AUTHORITIES_KEY = "auth";

	@Value("${jwt.access_secret}")
	private String accessSecret;

	@Value("${jwt.refresh_secret}")
	private String refreshSecret;

	@Value("${jwt.access_token_expiration}")
	private long accessTokenExpiration;

	@Value("${jwt.refresh_token_expiration}")
	private long refreshTokenExpiration;

	public Claims parseClaims(String token, boolean isRefreshToken) {
		try {
			return Jwts.parser()
				.setSigningKey(isRefreshToken ? refreshSecret : accessSecret)
				.parseClaimsJws(token)
				.getBody();
		} catch (ExpiredJwtException e) {
			throw new ExpiredTokenException(e);
		}
	}

	public void validateToken(String token, boolean isRefreshToken) {
		try {
			parseClaims(token, isRefreshToken);
		} catch (SignatureException | UnsupportedJwtException | IllegalArgumentException | MalformedJwtException e) {
			throw new InvalidTokenException();
		} catch (ExpiredJwtException e) {
			throw new ExpiredTokenException();
		}
	}

	public Authentication getAuthentication(String token) {
		Claims claims = parseClaims(token, false);

		Collection<? extends GrantedAuthority> authorities =
			Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());

		String userId = claims.getSubject();
		return new UsernamePasswordAuthenticationToken(userId, null, authorities);
	}

	public String createAccessToken(String userId, Role role) {
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + accessTokenExpiration);

		return Jwts.builder()
			.setSubject(userId)
			.claim(AUTHORITIES_KEY, role.getKey())
			.setIssuedAt(now)
			.setExpiration(expiryDate)
			.signWith(SignatureAlgorithm.HS512, accessSecret)
			.compact();
	}

	public String createRefreshToken(String userId) {
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + refreshTokenExpiration);

		return Jwts.builder()
			.setSubject(userId)
			.setIssuedAt(now)
			.setExpiration(expiryDate)
			.signWith(SignatureAlgorithm.HS512, refreshSecret)
			.compact();
	}
}