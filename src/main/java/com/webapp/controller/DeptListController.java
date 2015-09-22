package com.webapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.webapp.dao.DeptDao;
import com.webapp.datasource.EmployeeDataSource;
import com.webapp.model.Dept;

public class DeptListController implements Controller {
	
	static Log log = LogFactory.getLog(DeptListController.class);
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@");
		log.info("DeptListController called...");
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@");
		
		DeptDao dao = DeptDao.newInstance();
		List<Dept> list = dao.selectAll();
		list.size();
		request.setAttribute("model", list);
		
		return "/WEB-INF/views/deptlist.jsp";
	}

}
