package com.chatbot.backend.domain.admin.dto.request;

import org.springframework.web.bind.annotation.RequestParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FeedbackRequestDto {
	private Boolean isPositive;
	private Integer page;
	private Integer size;
	private String sortBy;
	private String sortDir;
}
