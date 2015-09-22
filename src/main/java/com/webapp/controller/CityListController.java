package com.webapp.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.EmptyResultDataAccessException;

import com.webapp.dao.DeptDao;

public class CityListController implements Controller {
	
	static Log log = LogFactory.getLog(CityListController.class);
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException  {
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@");
		log.info("CityListController called...");
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@");
		
		return "";
	}

}
