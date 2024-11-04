package com.chatbot.backend.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chatbot.backend.domain.user.entity.User;
import com.chatbot.backend.domain.user.exception.UserNotFoundException;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findUserById(Long id);

	default User findByIdOrElseThrow(Long id) {
		return findById(id).orElseThrow(UserNotFoundException::new);
	}

}