package com.chatbot.backend.domain.file.controller;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;

import com.chatbot.backend.domain.file.service.FileService;
import com.chatbot.backend.global.config.SecurityConfig;
import com.chatbot.backend.global.jwt.JwtFilter;
import com.chatbot.backend.global.jwt.JwtProvider;

// WebMvcTest 사용하여 MVC 슬라이스 테스트
@WebMvcTest(FileController.class)
@Import({SecurityConfig.class, JwtProvider.class, JwtFilter.class})
public class FileControllerTest {
	// MockMvc를 통한 엔드포인트 테스트
	@Autowired
	private MockMvc mockMvc;

	// 서비스 계층 Mocking
	@MockBean
	private FileService fileService;

	@Test
	@DisplayName("파일 업로드 성공 Test")
	void createFileSuccess() throws Exception {
		// given
		String content = "테스트 파일의 내용입니다.";
		// Multipart 파일 업로드 테스트
		MockMultipartFile mockMultipartFile = new MockMultipartFile("file", "test.txt", "text/plain",
			content.getBytes());
		String expectedPath = "/upload/profiles/test.txt";
		given(fileService.saveProfileFile(any(MultipartFile.class))).willReturn(expectedPath);

		// when & then
		mockMvc.perform(
				multipart("/api/files").file(mockMultipartFile)
					.contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
			)
			.andExpect(status().isOk())
			.andExpect(content().string(expectedPath));
	}

	@Test
	@DisplayName("파일 없이 요청시 500 에러 반환 Test")
	void createFileWithoutFile() throws Exception {
		mockMvc.perform(multipart("/api/files")).andExpect(status().isInternalServerError());
	}
}