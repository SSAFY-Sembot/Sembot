package com.chatbot.backend.domain.file.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chatbot.backend.domain.file.service.FileService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "File", description = "파일 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/files")
@Slf4j
public class FileController {
	private final FileService fileService;

	@Operation(
		summary = "파일 URL 생성",
		description = "새로운 파일 URL을 생성합니다. MultipartFile을 첨부할 수 있습니다."
	)
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<String> createFile(
		@RequestPart(value = "file", required = true) MultipartFile file
	) {
		return ResponseEntity.ok().body(fileService.saveProfileFile(file));
	}
}
