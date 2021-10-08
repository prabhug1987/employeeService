package com.example.user.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.user.model.User;
import com.example.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository UserRepository;

	@Transactional
	@Override
	public Optional<User> deleteUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<User> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<User> findUserById(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public Optional<User> saveUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public Optional<User> updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
