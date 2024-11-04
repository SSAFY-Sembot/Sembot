package com.chatbot.backend.domain.user.dto.request;

import com.chatbot.backend.domain.user.entity.User;
import com.chatbot.backend.global.jwt.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SignupRequestDto {

	@Email
	private String email;

	@NotBlank
	private String password;

	@NotBlank
	private String name;

	@NotBlank
	private String employeeNum;

	@NotBlank
	private String department;
	private String profileUrl;

	public User toEntity(String password, Integer level, Boolean isDeleted, Role role){
		return User.builder()
			.email(email)
			.password(password)
			.name(name)
			.employeeNum(employeeNum)
			.department(department)
			// TODO : profileUrl이 null 이면 default profile
			.profileUrl(profileUrl != null ? profileUrl : "")
			.level(level != null ? level : 1)
			.isDeleted(isDeleted != null ? isDeleted : false)
			.role(role != null ? role : (department.equals("인사과") ? Role.USER_WRITE : Role.USER))
			.build();
	}

	public User toEntity(String password) {
		return toEntity(password, null, null, null);
	}


}
