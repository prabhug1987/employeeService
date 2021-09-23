package com.example.user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.UserServiceApplication;

@RestController
public class RestartController {

	@PostMapping
	public void restart() {
		UserServiceApplication.restart();
	}
}
