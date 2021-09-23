package com.example.user.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.user.model.User;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> userClass) {
		return User.class.equals(userClass);
	}

	@Override
	public void validate(Object object, Errors errors) {
		User user = (User) object;
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		//if(user.getUserName())
	}

}
