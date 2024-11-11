package com.chatbot.backend.domain.remark.dto.response;

import java.time.LocalDateTime;

import com.chatbot.backend.domain.board.dto.response.BoardWriterResponseDto;
import com.chatbot.backend.domain.remark.entity.Remark;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

// 비고 수정 요청을 위한 DTO
// record로 사용하여 불변 객체로 구현
@Schema(description = "비고 수정 DTO")
@Builder
public record RemarkDetailResponseDto(
	@Schema(description = "비고 ID", example = "1")
	Long remarkId,

	@Schema(description = "비고 내용", example = "비고의 내용입니다.")
	String contents,

	@Schema(description = "작성자 정보")
	BoardWriterResponseDto writer,

	@Schema(description = "비고 생성 시간")
	LocalDateTime createdAt,

	@Schema(description = "게시판 ID", example = "1")
	Long boardId
) {
	// 응답 DTO 생성
	public static RemarkDetailResponseDto of(Remark remark) {
		return RemarkDetailResponseDto.builder()
			.remarkId(remark.getId())
			.contents(remark.getContents())
			.writer(BoardWriterResponseDto.of(remark.getUser()))
			.createdAt(remark.getCreatedAt())
			.boardId(remark.getBoard().getId())
			.build();
	}
}
