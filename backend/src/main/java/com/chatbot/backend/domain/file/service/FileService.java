package com.chatbot.backend.domain.file.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	String saveFile(MultipartFile file, String dirName);

	String saveFile(MultipartFile file);
}