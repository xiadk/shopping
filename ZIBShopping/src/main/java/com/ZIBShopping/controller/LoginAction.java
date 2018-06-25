package com.ZIBShopping.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ZIBShopping.dto.User;
import com.ZIBShopping.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginAction {
	@Autowired
	private UserService userService;

	@RequestMapping("/index")
	public String index(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		User user = userService.findUserByPhone(15079594318l);
		request.setAttribute("value", user.getName());
		return "index";
	}

}
