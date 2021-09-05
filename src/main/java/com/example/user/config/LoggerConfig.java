package com.example.user.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.user.UserServiceApplication;

@Configuration
public class LoggerConfig {

	@Bean
	public Logger logger() {
		return LoggerFactory.getLogger(UserServiceApplication.class);
	}
	
}
