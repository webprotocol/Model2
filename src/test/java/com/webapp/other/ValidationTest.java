package com.webapp.other;

import java.util.Collections;

import org.springframework.validation.Errors;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.Validator;

import com.webapp.form.DeptForm;


public class ValidationTest {

	public static void main(String[] args) {
		DeptForm form = new DeptForm();
		form.setDeptno("x123");	// 123 or xxx
		form.setDname("xxxxxx");
		form.setLoc("yyyyy");
		
		Errors errors = new MapBindingResult(Collections.emptyMap(), "dept");
		
		form.validate(errors);
		
		if (errors.hasFieldErrors("deptno")) {
			System.out.println("code = " + errors.getFieldError("deptno").getCode());
			System.out.println("message = " + errors.getFieldError("deptno").getDefaultMessage());
			System.out.println("field name = " + errors.getFieldError("deptno").getField());
		}
		if (errors.hasFieldErrors("dname")) {
			System.out.println("code = " + errors.getFieldError("dname").getCode());
			System.out.println("message = " + errors.getFieldError("dname").getDefaultMessage());
			System.out.println("field name = " + errors.getFieldError("dname").getField());
		}
		if (errors.hasFieldErrors("loc")) {
			System.out.println("code = " + errors.getFieldError("loc").getCode());
			System.out.println("message = " + errors.getFieldError("loc").getDefaultMessage());
			System.out.println("field name = " + errors.getFieldError("loc").getField());
		}
		
		
		
		
	}

}
