package com.zensar.olxlogin.service;


import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.zensar.olxlogin.entity.User;


public interface LoginService {

	List<User> getAllUsers(String username, String password);

	User registerUser(User user);

	boolean logoutUser(long id1, String username, String password);

	String loginUser(User user);

}
