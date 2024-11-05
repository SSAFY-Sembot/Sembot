package com.chatbot.backend.domain.file.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	String saveFile(MultipartFile file, String dirName);

	String saveProfileFile(MultipartFile file);

	Resource loadFileAsResource(String fileUrl);
}