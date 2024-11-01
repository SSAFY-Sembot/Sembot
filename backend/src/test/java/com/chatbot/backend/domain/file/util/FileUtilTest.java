package com.chatbot.backend.domain.file.util;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.mock.web.MockMultipartFile;

public class FileUtilTest {

	@TempDir
	Path tempDir;

	private String basePath;

	@BeforeEach
	void setUp() {
		basePath = tempDir.toString();
	}

	@Test
	@DisplayName("디렉토리 생성 Test")
	void createDirectoryTest() {
		// given
		String dirName = "testDir";

		// when
		String createPath = FileUtil.createDirectory(basePath, dirName);

		// then
		File directory = new File(createPath);
		assertTrue(directory.exists());    // directory 가 만들어졌는 지 확인
		assertTrue(directory.isDirectory());    // directory가 Folder인지 확인
		assertEquals(basePath + "/" + dirName, createPath);    // 생성된 경로가 의도한 경로로 생성되었는 지 확인
	}

	@Test
	@DisplayName("파일명 생성 Test (UUID 형식 확인)")
	void generateFileNameTest() {
		// given
		String originalFileName = "test.pdf";

		// when
		String generatedFileName = FileUtil.generateFileName(originalFileName);

		// then
		assertTrue(generatedFileName.endsWith(".pdf"));    // 확장자명이 유지되었는 지 확인
		assertEquals(36 + 4, generatedFileName.length());    // UUID(36자) + 확장자(4자)
	}

	@Test
	@DisplayName("파일 확장자 추출 Test")
	void extractExtensionTest() {
		// given
		String filename1 = "test.jpg";
		String filename2 = "test2.doc.pdf";
		String filename3 = "noetension";

		// when & then
		assertEquals(".jpg", FileUtil.extractExtension(filename1));
		assertEquals(".pdf", FileUtil.extractExtension(filename2));
		assertThrows(StringIndexOutOfBoundsException.class, () -> FileUtil.extractExtension(filename3));
	}

	@Test
	@DisplayName("전체 경로 생성 Test")
	void createFullPathTest() {
		// given
		String uploadDir = "/upload/dir";
		String fileName = "test.jpg";

		// when
		String fullPath = FileUtil.createFullPath(uploadDir, fileName);

		// then
		assertEquals(uploadDir + "/" + fileName, fullPath);
	}

	@Test
	@DisplayName("파일 저장 Test")
	void saveFileTest() throws IOException {
		// given
		String content = "테스트 파일의 내용입니다.";
		MockMultipartFile mockMultipartFile = new MockMultipartFile("file", "test.txt", "text/plain",
			content.getBytes());
		String fullPath = tempDir.resolve("text.txt").toString();

		// when
		FileUtil.saveFile(mockMultipartFile, fullPath);

		// then
		File savedFile = new File(fullPath);
		assertTrue(savedFile.exists());
		assertTrue(savedFile.isFile());
	}
}
