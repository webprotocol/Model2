package com.webapp.datasource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class EmployeeDataSource extends DriverManagerDataSource {
	static String driverClassName = "oracle.jdbc.OracleDriver";
	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static String username = "scott";
	static String password = "tiger";
	
	public EmployeeDataSource() {
		setDriverClassName(driverClassName);
		setUrl(url);
		setUsername(username);
		setPassword(password);
	}
}
