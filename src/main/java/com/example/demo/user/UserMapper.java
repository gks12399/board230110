package com.example.demo.user;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper{
	
	public UserModel login(UserModel user);
	public int findId(String id);
	public void userAdd(HashMap<String, Object> map);
		
}
