package com.example.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@EnableEurekaClient
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
@SpringBootApplication
@EnableCaching
public class UserServiceApplication {

	private static ConfigurableApplicationContext context;
	
	
	public static void main(String[] args) {
		context = SpringApplication.run(UserServiceApplication.class, args);
	}

	/*@Bean(name = "entitySessionFactory")
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
			return sessionFactory;
	}*/
	
	/*public static void restart() {
		Thread thread = new Thread(() -> {
			context.close();
			context = SpringApplication.run(UserServiceApplication.class, "--spring.profiles.active=dev");
		});
		
		thread.setDaemon(false);
		thread.start();
	}*/
	
	

}
