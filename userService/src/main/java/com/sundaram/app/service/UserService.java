package com.sundaram.app.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sundaram.app.model.Users;
import com.sundaram.app.repository.UserRepository;
import com.sundaram.app.util.exception.UserNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Users getUserById(Integer id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));
	}

	public Page<Users> getAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	public Users createNewUser(String firstName, String lastName, int phoneNumber, String email, String password) {
		Users users = new Users(phoneNumber, password, password, email, firstName, lastName, phoneNumber, password,
				new Date(), new Date());
		return userRepository.save(users);
	}

}
