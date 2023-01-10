package com.example.demo.user;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

	UserModel login(UserModel user);
	
}
