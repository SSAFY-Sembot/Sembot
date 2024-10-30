package com.chatbot.backend.global.util;

import com.chatbot.backend.global.security.CustomUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUtil {


    private SecurityUtil() {

    }
    // 현재 인증된 사용자의 ID를 가져오는 메서드
    public static Long getCurrentUserId() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((CustomUserDetails) principal).getId();
        } else {
            throw new RuntimeException("인증된 사용자를 찾을 수 없습니다.");
        }
    }
}
