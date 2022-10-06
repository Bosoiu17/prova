package com.proconsul.service;

import com.proconsul.entity.User;

public interface UserService {

	public String saveUser(User user);
	public String findUserByEmail(String email);
}