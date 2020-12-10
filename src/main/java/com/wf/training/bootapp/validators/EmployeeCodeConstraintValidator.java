package com.wf.training.bootapp.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmployeeCodeConstraintValidator 
		implements ConstraintValidator<EmployeeCode, String>{

	private String expectedPrefix;
	
	// to access the attribute value
	@Override
	public void initialize(EmployeeCode constraintAnnotation) {
		this.expectedPrefix = constraintAnnotation.prefix();
	}
	
	@Override
	public boolean isValid(String userValue, ConstraintValidatorContext context) {
		// logic of constraint
		if(userValue.startsWith(expectedPrefix))
			return true;
		return false;
	}
}
