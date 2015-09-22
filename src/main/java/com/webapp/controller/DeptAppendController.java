package com.webapp.controller;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.Errors;
import org.springframework.validation.MapBindingResult;

import com.webapp.dao.DeptDao;
import com.webapp.form.DeptForm;

public class DeptAppendController implements Controller {
	
	static Log log = LogFactory.getLog(DeptAppendController.class);
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@");
		log.info("DeptAppendController called...");
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@");
		
		String method = request.getMethod();
		String view="";
		switch (method.toUpperCase()) {
		case "GET":
			view = "/WEB-INF/views/deptAppendForm.jsp"; 
			break;
		case "POST":
			String deptno = request.getParameter("deptno");	// 숫자 2자리
			String dname = request.getParameter("dname");	// 14까지 nullable
			String loc = request.getParameter("loc");		// 13까지 nullable
			log.info("deptno = [" + deptno + "]");
			log.info("dname = [" + dname + "]");
			log.info("loc = [" + loc + "]");
			
			Errors errors = new MapBindingResult(Collections.emptyMap(), "Dept");
			DeptForm form = new DeptForm(deptno, dname, loc);
			
			request.setAttribute("errors", errors);
			request.setAttribute("dept", form);
			
			form.validate(errors);
			view = "/WEB-INF/views/deptAppendForm.jsp";
			
			try {
				if (errors.hasErrors()) {
					throw new RuntimeException();
				}
				
				DeptDao dao = DeptDao.newInstance();
				int rtn = dao.insert(form.getDept());
				
				view = "/WEB-INF/views/deptAppendSuccess.jsp";
				
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
