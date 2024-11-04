package com.chatbot.backend.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

// Swagger (OpenAPI) 문서 설정을 담당
@OpenAPIDefinition(info = @Info(
	title = "SemBot API",
	description = "SemBot 명세서",
	version = "v1.0.0"))
@Configuration
public class SwaggerConfig {
	@Bean
	public OpenAPI openApi() {
		String jwt = "JWT";
		// JWT 인증 요구사항 설정
		SecurityRequirement securityRequirement = new SecurityRequirement().addList("JWT");
		// JWT 보안 스키마 설정
		Components components = new Components().addSecuritySchemes(jwt, new SecurityScheme()
			.name(jwt)
			.type(SecurityScheme.Type.HTTP)
			.scheme("bearer")
			.bearerFormat("JWT")
		);

		return new OpenAPI()
			.addServersItem(new Server().url("/"))
			.addSecurityItem(securityRequirement)
			.components(components);
	}
}