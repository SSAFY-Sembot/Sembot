package com.chatbot.backend.domain.file.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.chatbot.backend.domain.file.exception.FileDownloadException;
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

	/**
	 * 파일을 저장하고 저장된 경로를 반환
	 * @param file 저장할 MultipartFile
	 * @param dirName 저장할 디렉토리 이름
	 * @return 저장된 파일의 경로
	 * @throws FileUploadFailedException 파일 업로드 실패 시 발생
	 */
	public String saveFile(MultipartFile file, String dirName) {
		// 파일이 없으면 null 반환
		if (file == null || file.isEmpty()) {
			return null;
		}

		try {
			// 디렉토리 생성
			String uploadDir = FileUtil.createDirectory(uploadPath, dirName);
			// 고유한 파일명 생성
			String saveFileName = FileUtil.generateFileName(file.getOriginalFilename());
			// 전체 파일 경로 생성
			String fullFilePath = FileUtil.createFullPath(uploadDir, saveFileName);

			// 파일 생성
			FileUtil.saveFile(file, fullFilePath);
			return FileUtil.createFilePath(dirName, saveFileName);
		} catch (IOException ioException) {
			throw new FileUploadFailedException();
		}
	}

	@Override
	public String saveProfileFile(MultipartFile file) {
		return saveFile(file, PROFILE_UPLOAD_DIR);
	}

	/**
	 * 파일 Path를 기반으로 파일 리소스를 로드
	 * @param fileUrl 파일 URL
	 * @return 파일 리소스
	 * @throws FileDownloadException 파일 다운로드 실패 시 발생
	 */
	@Override
	public Resource loadFileAsResource(String fileUrl) {
		try {
			Path fullPath = Paths.get(uploadPath, fileUrl).normalize();

			File file = fullPath.toFile();
			if (!file.exists()) {
				throw new FileNotFoundException();
			}
			return new FileSystemResource(file);
		} catch (Exception ex) {
			throw new FileDownloadException();
		}
	}
}