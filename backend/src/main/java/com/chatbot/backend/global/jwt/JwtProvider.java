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
import com.chatbot.backend.global.security.CustomUserDetails;

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
	private static final String USER_ID_KEY = "userId";
	private static final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;

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

		Long userId = ((Number)claims.get(USER_ID_KEY)).longValue();
		String email = claims.getSubject();
		Role role = Role.valueOf(claims.get(AUTHORITIES_KEY).toString());

		CustomUserDetails userDetails = CustomUserDetails.of(userId, email, role);

		return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
	}

	public String createAccessToken(Long userId, String email, Role role) {
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + accessTokenExpiration);

		return Jwts.builder()
			.setSubject(email)
			.claim(USER_ID_KEY, userId)
			.claim(AUTHORITIES_KEY, role.getKey())
			.setIssuedAt(now)
			.setExpiration(expiryDate)
			.signWith(SignatureAlgorithm.HS512, accessSecret)
			.compact();
	}

	public String createRefreshToken(Long userId, String email) {
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + refreshTokenExpiration);

		return Jwts.builder()
			.setSubject(email)
			.claim(USER_ID_KEY, userId)
			.setIssuedAt(now)
			.setExpiration(expiryDate)
			.signWith(SignatureAlgorithm.HS512, refreshSecret)
			.compact();
	}
}