package com.chatbot.backend.domain.file.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.chatbot.backend.domain.file.exception.FileUploadFailedException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class FileServiceImpl implements FileService {
	private static final String PROFILE_UPLOAD_DIR = "profiles";

	@Value("${file.upload.path}")
	private String uploadPath;

	// 파일을 저장하고 저장된 경로를 반환
	public String saveFile(MultipartFile file, String dirName) {
		// 파일이 없으면 null 반환
		if (file == null || file.isEmpty()) {
			return null;
		}

		try {
			// 1. 업로드 될 디렉토리 생성
			String uploadDir = uploadPath + "/" + dirName;
			File directory = new File(uploadDir);
			if (!directory.exists()) {
				directory.mkdirs();
			}

			// 2. 저장될 파일명 생성 (UUID + 원본 확장자)
			String originalFilename = file.getOriginalFilename();
			String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
			String savedFilename = UUID.randomUUID() + extension;

			// 3. 파일 저장
			String fullPath = uploadDir + "/" + savedFilename;
			File dest = new File(fullPath);
			file.transferTo(dest);

			log.info("파일 저장 완료: {}", fullPath);
			return fullPath;
		} catch (IOException ioException) {
			throw new FileUploadFailedException();
		}
	}

	@Override
	public String saveFile(MultipartFile file) {
		return saveFile(file, PROFILE_UPLOAD_DIR);
	}
}