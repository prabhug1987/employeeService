package com.example.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.example.user.repository.UserRepository;

@ControllerAdvice
@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@ExceptionHandler(UserNotFoundException.class)
	@GetMapping("/user")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@ExceptionHandler(UserNotFoundException.class)
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
			throws UserNotFoundException {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("user not found for this id :: " + userId));
		return ResponseEntity.ok().body(user);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	@PostMapping("/users")
	public User createUser(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}

	@ExceptionHandler(UserNotFoundException.class)
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
			@Valid @RequestBody User user) throws UserNotFoundException {

		User userInstance = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("user not found for this Id :: " + userId));
		//userInstance.
		
		final User updatedUser = userRepository.save(user);
		

		return ResponseEntity.ok(updatedUser);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	@DeleteMapping
	public Map<String, Boolean> deleteuser(@PathVariable(value = "id") Long userId)throws UserNotFoundException{
		User user = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("user not found for this Id :: "+ userId));
		userRepository.delete(user);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
