package com.proconsul.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proconsul.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

	public User findByEmail(String email);
}
