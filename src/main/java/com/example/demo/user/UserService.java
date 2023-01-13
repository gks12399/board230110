package com.example.demo.user;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

	public UserModel login(UserModel user);
	public int findId(String id);
	public void userAdd(HashMap<String, Object> map);
}
