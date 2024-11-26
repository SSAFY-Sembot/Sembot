package com.chatbot.backend.global.util;

import java.lang.reflect.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

// application/octet-stream Content-Type을 가진 요청 본문을 JSON으로 처리하기 위한 커스텀 컨버터
// 읽기(Read) 작업만 지원하며, 쓰기(Write) 작업은 지원하지 않습니다.
@Component
public class OctetStreamJsonMessageConverter extends AbstractJackson2HttpMessageConverter {
	@Autowired
	public OctetStreamJsonMessageConverter(ObjectMapper objectMapper) {
		super(objectMapper, MediaType.APPLICATION_OCTET_STREAM);
	}

	// 쓰기 작업을 지원하지 않습니다.
	// ByteArrayHttpMessageConverter가 이미 쓰기 작업을 담당하고 있음
	@Override
	public boolean canWrite(Class<?> clazz, MediaType mediaType) {
		return false;
	}

	@Override
	public boolean canWrite(Type type, Class<?> clazz, MediaType mediaType) {
		return false;
	}

	@Override
	protected boolean canWrite(MediaType mediaType) {
		return false;
	}
}