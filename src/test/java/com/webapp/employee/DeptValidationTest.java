package com.webapp.employee;

import java.util.Collections;

import org.springframework.validation.Errors;
import org.springframework.validation.MapBindingResult;

public class DeptValidationTest {

	public static void main(String[] args) {
		
		Errors errors = new MapBindingResult(Collections.emptyMap(), "Dept");
		
		errors.reject("dept", "부서 중복 에러 입니다.");
		
		if (errors.hasGlobalErrors()) {
			System.out.println(errors.getGlobalError().getDefaultMessage());
		}
		

	}

}
