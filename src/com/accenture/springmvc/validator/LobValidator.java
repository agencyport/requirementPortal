package com.accenture.springmvc.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.accenture.springmvc.entity.Lob;


public class LobValidator implements Validator {

		public boolean supports(Class<?> paramClass) {
			return Lob.class.equals(paramClass);
		}

		public void validate(Object obj, Errors errors) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lobName", "not valid lob");
		}
}