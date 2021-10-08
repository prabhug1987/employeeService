package com.example.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestartController {

	@RequestMapping(method = RequestMethod.POST, value="restart")
	public void restart() {
		//UserServiceApplication.restart();
	}
}
