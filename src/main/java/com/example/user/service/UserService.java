package com.example.user.service;

import org.springframework.stereotype.Service;

import com.example.user.model.User;

@Service
public interface UserService {

	User findyById();

	User saveUser();

	User updateUser();

	User deleteUser();
}
