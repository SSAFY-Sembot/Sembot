package com.chatbot.backend.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories
public class RedisConfig {

	// RedisConnectionFactory 설정
	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		// 기본적으로 localhost와 기본 포트를 사용합니다.
		return new LettuceConnectionFactory("localhost", 6379); // 필요 시 호스트와 포트를 수정하세요.
	}

	// RedisTemplate 설정
	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory);

		// Key와 Value를 문자열로 직렬화
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new StringRedisSerializer());

		// Hash Key와 Hash Value도 문자열로 직렬화 (필요 시)
		template.setHashKeySerializer(new StringRedisSerializer());
		template.setHashValueSerializer(new StringRedisSerializer());

		template.afterPropertiesSet();
		return template;
	}
}
