package com.chatbot.backend.domain.file.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.util.ReflectionTestUtils;

public class FileServiceImplTest {
	private FileService fileService;

	// @TempDir을 사용한 임시 디렉토리 테스트
	@TempDir
	Path tempDir;

	@BeforeEach
	void setUp() {
		fileService = new FileServiceImpl();
		ReflectionTestUtils.setField(fileService, "uploadPath", tempDir.toString());
	}

	@Test
	@DisplayName("프로필 파일 저장 성공 Test")
	void saveProfileFileSuccess() {
		// given
		MockMultipartFile mockMultipartFile = new MockMultipartFile(
			"file",
			"test.jpg",
			"image/jpeg",
			"test image content".getBytes());

		// when
		String savedPath = fileService.saveProfileFile(mockMultipartFile);

		// then
		assertNotNull(savedPath);
		assertTrue(new File(savedPath).exists());
		assertTrue(savedPath.contains("profiles"));
	}

	@Test
	@DisplayName("빈 파일 저장 시 NULL 반환 Test")
	void saveProfileFileNull() {
		// given
		MockMultipartFile mockMultipartFile = new MockMultipartFile(
			"file",
			"",
			"image/jpeg",
			"".getBytes());

		// when
		String result = fileService.saveProfileFile(mockMultipartFile);

		// then
		assertNull(result);
	}

	@Test
	@DisplayName("NULL 파일 저장 시 NULL 반환 Test")
	void saveNullFile() {
		// given

		// when
		String result = fileService.saveProfileFile(null);

		// then
		assertNull(result);
	}
}