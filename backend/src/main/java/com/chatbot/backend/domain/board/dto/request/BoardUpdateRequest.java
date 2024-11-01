package com.chatbot.backend.domain.board.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

// 게시글 수정 요청을 위한 DTO
// record로 사용하여 불변 객체로 구현
@Schema(description = "게시글 수정 요청 DTO")
public record BoardUpdateRequest(
	@Schema(description = "수정할 게시글 제목", example = "수정된 제목입니다")
	String title,

	@Schema(description = "수정할 게시글 내용", example = "수정된 내용입니다")
	String contents,

	@Schema(description = "수정할 카테고리", example = "카테고리 1")
	String category,

	@Schema(description = "수정할 레벨 (1-3)", example = "2")
	Integer level
) {
}