package com.example.user.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.exception.UserNotFoundException;
import com.example.user.model.User;
import com.example.user.service.UserService;

@ControllerAdvice
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@ExceptionHandler(UserNotFoundException.class)
	@GetMapping("/user")
	public Optional<User> getAllUsers() {
		return userService.findAllUsers();
	}

	@ExceptionHandler(UserNotFoundException.class)
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) throws UserNotFoundException {
		User user = userService.findUserById(userId)
				.orElseThrow(() -> new UserNotFoundException("user not found for this id :: " + userId));
		return ResponseEntity.ok().body(user);
	}

	@ExceptionHandler(UserNotFoundException.class)
	@PostMapping("/users")
	public Optional<User> createUser(@Valid @RequestBody User user) {
		return userService.saveUser(user);
	}

	@ExceptionHandler(UserNotFoundException.class)
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId, @Valid @RequestBody User user)
			throws UserNotFoundException {

		User userInstance = userService.findUserById(userId)
				.orElseThrow(() -> new UserNotFoundException("user not found for this Id :: " + userId));
		// userInstance.

		final Optional<User> updatedUser = userService.updateUser(user);

		return ResponseEntity.ok(updatedUser.get());
	}

	@ExceptionHandler(UserNotFoundException.class)
	@DeleteMapping
	public Map<String, Boolean> deleteuser(@PathVariable(value = "id") Long userId) throws UserNotFoundException {
		User user = userService.findUserById(userId)
				.orElseThrow(() -> new UserNotFoundException("user not found for this Id :: " + userId));
		userService.deleteUser(user);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
