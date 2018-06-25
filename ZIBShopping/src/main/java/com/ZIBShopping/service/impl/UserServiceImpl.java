package com.ZIBShopping.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ZIBShopping.dao.IUserDao;
import com.ZIBShopping.dto.User;
import com.ZIBShopping.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private IUserDao userDao;
	public Integer register(User user) {
		return userDao.register(user);
	}
	public User findUserById(int id) {
		return userDao.findUserById(id);
	}
	public User findUserByPhone(Long phone) {
		return userDao.findUserByPhone(phone);
	}
}