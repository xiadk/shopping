package com.ZIBShopping.dao;


import org.springframework.stereotype.Repository;

import com.ZIBShopping.dto.User;

@Repository
public interface IUserDao {

	Integer register(User user);
	
	User findUserById(int id);
	
	User findUserByPhone(Long phone);

}