package com.chatbot.backend.domain.admin.service;

import jakarta.servlet.http.HttpServletRequest;

public interface AdminService {
	void postCategory(HttpServletRequest request, String name);
}
