package com.example.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

import com.netflix.discovery.shared.Application;

@SpringBootApplication
@EnableEurekaClient
public class UserServiceApplication {

	private static ConfigurableApplicationContext context;
	
	public static void main(String[] args) {
		context = SpringApplication.run(UserServiceApplication.class, args);
	}
	
	public static void restart() {
		Thread thread = new Thread(() -> {
			context.close();
			context = SpringApplication.run(UserServiceApplication.class, "--spring.profiles.active=dev");
		});
		
		thread.setDaemon(false);
		thread.start();
	}
	
	

}
