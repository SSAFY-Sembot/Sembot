package com.chatbot.backend.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// JPA Auditing 기능을 활성화하는 설정 클래스
// Entity의 생성일시, 수정일시 등을 자동으로 관리할 수 있게 해줌
@Configuration
@EnableJpaAuditing
public class JpaConfig {
}
