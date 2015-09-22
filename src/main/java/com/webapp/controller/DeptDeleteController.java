package com.webapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;

import com.webapp.dao.DeptDao;

public class DeptDeleteController implements Controller {
	
	static Log log = LogFactory.getLog(DeptDeleteController.class);
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@");
		log.info("DeptDeleteController called...");
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@");
		
		String deptno = request.getParameter("deptno");
		DeptDao dao = DeptDao.newInstance();
		try {
			dao.delete(Integer.parseInt(deptno));
		} catch (DataAccessException e) {
			log.error("delete error deptno=" + deptno, e);
		}
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/employee?cmd=deptlist");
		return null;
	}

}
