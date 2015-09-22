package com.webapp.datasource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class WorldDataSource extends DriverManagerDataSource {
	static String driverClassName = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/world";
	static String username = "world";
	static String password = "1234";
	
	public WorldDataSource() {
		setDriverClassName(driverClassName);
		setUrl(url);
		setUsername(username);
		setPassword(password);
	}
}
