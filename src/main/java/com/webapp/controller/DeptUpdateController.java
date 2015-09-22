package com.webapp.controller;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.validation.Errors;
import org.springframework.validation.MapBindingResult;

import com.webapp.dao.DeptDao;
import com.webapp.form.DeptForm;
import com.webapp.model.Dept;

public class DeptUpdateController implements Controller {
	
	static Log log = LogFactory.getLog(DeptUpdateController.class);
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@");
		log.info("DeptUpdateController called...");
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@");
		
		String method = request.getMethod();
		String view="";
		
		String deptno=null;
		String dname=null;
		String loc=null;
		
		Errors errors=null;
		DeptForm form=null;
		
		DeptDao dao=null;
		
		switch (method.toUpperCase()) {
		case "GET":
			deptno = request.getParameter("deptno");
			form = new DeptForm();
			form.setDeptno(deptno);
			
			errors = new MapBindingResult(Collections.emptyMap(), "Dept");
			form.validateDeptno(errors);
			request.setAttribute("errors", errors);
			
			try {
				if (!errors.hasErrors()) {
					dao = DeptDao.newInstance();
					Dept dept = dao.selectByDeptno(form.getDept().getDeptno());
					request.setAttribute("dept", dept);
				}
			} catch (EmptyResultDataAccessException e) {
				errors.rejectValue("deptno", "dept.deptno", "부서가 존재하지 않거나 삭제되었습니다.");
			}
			
			view = "/WEB-INF/views/deptUpdateForm.jsp"; 
			break;
		case "POST":
			deptno = request.getParameter("deptno");	// 숫자 2자리
			dname = request.getParameter("dname");	// 14까지 nullable
			loc = request.getParameter("loc");		// 13까지 nullable
			log.info("deptno = [" + deptno + "]");
			log.info("dname = [" + dname + "]");
			log.info("loc = [" + loc + "]");
			
			errors = new MapBindingResult(Collections.emptyMap(), "Dept");
			form = new DeptForm(deptno, dname, loc);
			
			request.setAttribute("errors", errors);
			request.setAttribute("dept", form);
			
			form.validate(errors);
			view = "/WEB-INF/views/deptUpdateForm.jsp";
			
			try {
				if (errors.hasErrors()) {
					throw new RuntimeException();
				}
				
				dao = DeptDao.newInstance();
				int rtn = dao.update(form.getDept());
				
				view = "/WEB-INF/views/deptUpdateSuccess.jsp";
				
			} catch (DuplicateKeyException e) {
				errors.reject("dept.duplicate", "부서 번호 중복 에러 입니다.");
			} catch (RuntimeException e) {
				errors.reject("dept.field", "필드 입력 에러 입니다. 확인하세요");
			}
			break;
		default:
			break;
		}
		
		return view;
	}

}
