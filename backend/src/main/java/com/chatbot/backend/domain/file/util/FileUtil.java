package com.chatbot.backend.domain.file.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileUtil {
	// 디렉토리 생성
	public static String createDirectory(String basePath, String dirName) {
		String uploadDir = basePath + "/" + dirName;
		File directory = new File(uploadDir);
		if (!directory.exists()) {
			directory.mkdirs();
		}
		return uploadDir;
	}

	// UUID 기반 파일명 생성
	public static String generateFileName(String originalFileName) {
		String extension = extractExtension(originalFileName);
		return UUID.randomUUID() + extension;
	}

	// 파일 확장자 추출
	public static String extractExtension(String filename) {
		return filename.substring(filename.lastIndexOf("."));
	}

	// 전체 경로 생성
	public static String createFullPath(String uploadDir, String fileName) {
		return uploadDir + "/" + fileName;
	}

	// 실제 파일 저장
	public static void saveFile(MultipartFile file, String fullPath) throws IOException {
		File dest = new File(fullPath);
		file.transferTo(dest);
		log.info("파일 저장 완료 : {}", fullPath);
	}
}
