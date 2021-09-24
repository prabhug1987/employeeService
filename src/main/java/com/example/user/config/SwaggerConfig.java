package com.example.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.user")).build().apiInfo(metaData());

	}

	private ApiInfo metaData() {
		return new ApiInfoBuilder().description("User Rest API for micro service").version("1.0")
				.termsOfServiceUrl("1 year").license("GPL license").licenseUrl("https://prabhug1987.com").build();
	}

}
