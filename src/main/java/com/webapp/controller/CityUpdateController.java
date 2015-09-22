package com.webapp.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.EmptyResultDataAccessException;

public class CityUpdateController implements Controller {
	
	static Log log = LogFactory.getLog(CityUpdateController.class);
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException  {
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@");
		log.info("CityUpdateController called...");
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@");
		
		return "";
	}

}
