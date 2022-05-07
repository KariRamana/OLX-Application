package com.zensar.olxlogin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.olxlogin.entity.User;
import com.zensar.olxlogin.repository.LoginRepository;

@Service
public class LoginServiceImp implements LoginService {

	static List<User> users = new ArrayList<User>();

	@Autowired
	private LoginRepository loginRepository;

	/*
	 * static { users.add(new User(1L, "Anand", "Kulkarni", "anand", "anand123",
	 * "anand@gmail.com", 12345));
	 * 
	 * }
	 */

	@Override
	public List<User> getAllUsers(String username, String password) {
		if (username.equals("anand") && password.equals("anand123")) {
			// return users;
			return loginRepository.findAll();
		}
		return null;
	}

	@Override
	public User registerUser(User user) {
		// users.add(user);
		return loginRepository.save(user);

	}

	@Override
	public boolean logoutUser(long id1, String username, String password) {

		if (username.equals("anand") && password.equals("anand123")) {
			/*
			 * for(User user:users) { if(user.getId()==id1) { // users.remove(user);
			 * 
			 * 
			 * return true; }
			 * 
			 * }
			 */
			loginRepository.deleteById(id1);
			return true;

		}
		return false;
	}

	@Override
	public String loginUser(User user) {
		// return user.getUserName()+"\n"+user.getPassword();
		return loginRepository.toString();
	}

}
