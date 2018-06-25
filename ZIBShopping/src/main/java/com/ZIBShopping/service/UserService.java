package com.ZIBShopping.service;

import com.ZIBShopping.dto.User;

public interface UserService {
	
	public Integer register(User user);
	
	public User findUserById(int id);
	
	public User findUserByPhone(Long phone);
	
}
