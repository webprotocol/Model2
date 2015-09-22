package com.webapp.form;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.webapp.model.Dept;

public class DeptForm implements Validator {
	
	static Log log = LogFactory.getLog(DeptForm.class);
	
	String deptno;	// 숫자  length = 1 ~ 2    Contraint
	String dname;	// 문자  length = 0 ~ 14
	String loc;		// 문자  length = 0 ~ 13
	
	public DeptForm() {
		
	}
	
	public DeptForm(String deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	
	public Dept getDept() {
		Dept dept = new Dept();
		dept.setDeptno(Integer.parseInt(deptno));
		dept.setDname(dname);
		dept.setLoc(loc);
		return dept;
	}
	
	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return DeptForm.class.isAssignableFrom(clazz);
	}

	public void validate(Errors errors) {
		validate(this, errors);
	}
	public void validateDeptno(Errors errors) {
		validateDeptno(this.deptno, errors);
	}
	public void validateDname(Errors errors) {
		validateDname(this.dname, errors);
	}
	public void validateLoc(Errors errors) {
		validateLoc(this.loc, errors);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		DeptForm form = (DeptForm) target;
		String deptno = form.getDeptno();
		String dname = form.getDname();
		String loc = form.getLoc();
		
		validateDeptno(deptno, errors);
		validateDname(dname, errors);
		validateLoc(loc, errors);
		
	}
	
	public void validateDeptno(String deptno, Errors errors) {
		/*
		 * deptno validation Numeric(2,0)
		 */
//		try {
//			Integer rtn = Integer.parseInt(deptno);
//			if (rtn >= 100) {
//				log.warn("deptno 는 2자리까지 가능합니다.");
//				errors.rejectValue("deptno", "dept.deptno.length", "부서번호는 2자리까지 가능합니다.");
//				
//			}
//			
//		} catch (NumberFormatException e) {
//			log.warn("deptno 는 숫자만 입력가능합니다.");
//			errors.rejectValue("deptno", "dept.deptno.typeMismatch", "부서번호는 숫자만 입력가능합니다.");
//		}
		
		String regex = "^[0-9]+$";
		if (!deptno.matches(regex)) {
			log.warn("deptno 는 숫자만 입력가능합니다.");
			errors.rejectValue("deptno", "dept.deptno.typeMismatch", "부서번호는 숫자만 입력가능합니다.");
		} else {
			regex = "^[0-9]{1,2}$";
			if (!deptno.matches(regex)) {
				log.warn("deptno 는 2자리까지 가능합니다.");
				errors.rejectValue("deptno", "dept.deptno.length", "부서번호는 2자리까지 가능합니다.");
			}
		}
	}
		
	public void validateDname(String dname, Errors errors) {
		/*
		 * dname validation varchar(14) nullable
		 * 
		 */
		
//		if(dname.length() > 14) {
//			log.warn("dname 은 14자리 까지 입력가능합니다");
//			errors.rejectValue("dname", "dept.dname.length", "부서이름은 14자리 까지 입력가능합니다");
//		}
		
		String regex = "^.{0,14}$";
		if (!dname.matches(regex)) {
			log.warn("dname 은 14자리 까지 입력가능합니다");
			errors.rejectValue("dname", "dept.dname.length", "부서이름은 14자리 까지 입력가능합니다");
		}
	}
	
	public void validateLoc(String loc, Errors errors) {
		
		/*
		 * loc validation varchar(13) nullable
		 * 
		 */
		
//		if(loc.length() > 13) {
//			log.warn("loc 은 13자리 까지 입력가능합니다");
//			errors.rejectValue("loc", "dept.loc.length", "부서위치이름은 13자리 까지 입력가능합니다");
//		}
		
		String regex = "^.{0,13}$";
		if (!loc.matches(regex)) {
			log.warn("loc 은 13자리 까지 입력가능합니다");
			errors.rejectValue("loc", "dept.loc.length", "부서위치이름은 13자리 까지 입력가능합니다");
		}
		
		
	}
	
	
}
