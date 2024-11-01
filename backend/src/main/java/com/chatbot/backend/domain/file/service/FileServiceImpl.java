package com.chatbot.backend.domain.file.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.chatbot.backend.domain.file.exception.FileUploadFailedException;
import com.chatbot.backend.domain.file.util.FileUtil;

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
			String uploadDir = FileUtil.createDirectory(uploadPath, dirName);
			String saveFileName = FileUtil.generateFileName(file.getOriginalFilename());
			String fullFilePath = FileUtil.createFullPath(uploadDir, saveFileName);

			FileUtil.saveFile(file, fullFilePath);
			return fullFilePath;
		} catch (IOException ioException) {
			throw new FileUploadFailedException();
		}
	}

	@Override
	public String saveProfileFile(MultipartFile file) {
		return saveFile(file, PROFILE_UPLOAD_DIR);
	}
}