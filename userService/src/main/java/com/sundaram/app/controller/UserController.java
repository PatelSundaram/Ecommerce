package com.sundaram.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sundaram.app.model.Users;
import com.sundaram.app.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/all")
	public ResponseEntity<Page<Users>> getAllUsers(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "0") int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Users> userlist = userService.getAll(pageable);
		return new ResponseEntity<>(userlist, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Users> getUserById(@PathVariable Integer id) {
		Users user = userService.getUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Users> newUser(@RequestBody Users users) {
		Users user = userService.createNewUser(users.getFirstName(), users.getLastName(), users.getPhoneNumber(),
				users.getEmail(), users.getPassword());
		return new ResponseEntity<Users>(user, HttpStatus.OK);
	}
}
