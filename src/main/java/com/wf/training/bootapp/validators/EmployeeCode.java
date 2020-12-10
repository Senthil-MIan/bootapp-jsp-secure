package com.wf.training.bootapp.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

// use this annotation as a validation/constraint annotation
@Constraint(validatedBy = EmployeeCodeConstraintValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmployeeCode {  // to represent/identify it as annotation
	// attributes of annotation
	
	// attribute : create/declare a method 
	// right now mandatory
	public String prefix();
	public String message();
	
	// boiler plate attribute for every constraint annotation
	
	// 1. groups : used to chain constraint
	// optional now..
	public Class<?>[] groups() default {}; // default value for att.
	
	// 2. payload : additional info about the constraint ( severity level, error-code..) 
	public Class<? extends Payload>[] payload() default {};
	
}


















