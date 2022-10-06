package com.proconsul.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.proconsul.entity.User;
import com.proconsul.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repo;
	
	

	//registrazione
	
	@Override
	public String saveUser(User user) {
		if (user != null) {
			try {
				if (repo.findById(user.getFiscalCode()).isEmpty()) {
					repo.save(user);
					return "login";
				}
				return "error";
			} catch (IllegalArgumentException e) {
				return "error";
			}
		} else {
			return "error";
		}
	}

	// log-in
	
	@Override
	public String findUserByEmail(String email) {
		if (email != null) {
			try {
				if(repo.findByEmail(email)!=null) {
					return "academiesList";
				}	
			}
				
			 catch (IllegalArgumentException e) {
				return "error";
			 }
			
		}
			return "error";
		
	}

}

