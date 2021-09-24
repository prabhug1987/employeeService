package com.example.user.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.user.model.User;

@Service
public interface UserService {

	Optional<User> deleteUser(User user);

	Optional<User> findAllUsers();
	
	Optional<User> findUserById(Long userId);

	Optional<User> saveUser(User user);

	Optional<User> updateUser(User user);

}
