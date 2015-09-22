package com.webapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.webapp.controller.Controller;

/**
 * Servlet implementation class EmployeeFrontControllerServlet
 */
public class EmployeeFrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static Log log = LogFactory.getLog(EmployeeFrontControllerServlet.class);
	
	Map<String, Controller> cmdMap;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeFrontControllerServlet() {
        super();
        cmdMap = new HashMap<String, Controller>();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	log.info("##########");
		log.info("init()... ");
		log.info("##########");
		String cmdpath = config.getInitParameter("cmdpath");
		log.info("cmdpath = " + cmdpath);
		
		ServletContext application = getServletContext();
		
		String realcmdpath = application.getRealPath(cmdpath);
		File file = new File(realcmdpath);
		FileInputStream in;
		try {
			in = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(in);
			
			for (Entry<Object, Object> e : prop.entrySet()) {
				String cmd = (String) e.getKey();
				String className = (String) e.getValue();
				Class cls = Class.forName(className);
				Controller c = (Controller) cls.newInstance();
				
				cmdMap.put(cmd, c);
			}
			
		} catch (FileNotFoundException e) {
			throw new ServletException("file not found... " + cmdpath, e);
		} catch (IOException e) {
			throw new ServletException("properties read error ...", e);
		} catch (ClassNotFoundException e) {
			throw new ServletException("class not found ...", e);
		} catch (InstantiationException e) {
			throw new ServletException("Controller 생성 에서 ...", e);
		} catch (IllegalAccessException e) {
			throw new ServletException("Controller 생성 에서 ...", e);
		}
			
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		log.info("#########################");
		log.info("processRequest()... " + request.getMethod());
		log.info("#########################");
		
		String cmd = request.getParameter("cmd");
		
		String view="";
//		try {
			if (cmd != null && !"".equals(cmd) && cmdMap.containsKey(cmd)) {
				Controller c = cmdMap.get(cmd);
				view = c.process(request, response);
			} else {
				view = "/WEB-INF/views/cmdNotFound.jsp";
			}
//		} catch (CannotGetJdbcConnectionException e) {
//			view = "/WEB-INF/errors/serverError.jsp";
//		}
		
		if (view != null && !"".equals(view)) {	
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
		
	}

}
