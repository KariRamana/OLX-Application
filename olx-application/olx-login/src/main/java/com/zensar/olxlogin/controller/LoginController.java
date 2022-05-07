package com.zensar.olxlogin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxlogin.entity.User;
import com.zensar.olxlogin.service.LoginService;

@RestController
@RequestMapping("/user")
public class LoginController {
	@Autowired
	private LoginService loginService;

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<User> getAllUsers(@RequestHeader("userName") String username,
			@RequestHeader("password") String password) {
		return loginService.getAllUsers(username, password);
	}

	@PostMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		User registerdUser = loginService.registerUser(user);
		if (registerdUser == null) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	@DeleteMapping("/logout/{userId}")
	public boolean logoutUser(@PathVariable("userId") long id, @RequestHeader("userName") String username,
			@RequestHeader("password") String password) {

		return loginService.logoutUser(id, username, password);

	}

	@PostMapping(value = "/authenticate", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public String loginUser(User user) {
		return loginService.loginUser(user);
	}

}
