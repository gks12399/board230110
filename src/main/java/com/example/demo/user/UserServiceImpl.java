package com.example.demo.user;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserModel login(UserModel user) {
		return userMapper.login(user);
	}
	
	@Override
	public int findId(String id) {
		int cnt = userMapper.findId(id);
		return cnt;
	}
	
	@Override
	public void userAdd(HashMap<String, Object> map) {
		userMapper.userAdd(map);
	}
}
