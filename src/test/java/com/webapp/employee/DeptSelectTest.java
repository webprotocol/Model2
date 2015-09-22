package com.webapp.employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.webapp.datasource.EmployeeDataSource;

public class DeptSelectTest {

	static Log log = LogFactory.getLog(DeptSelectTest.class);
	
	public static void main(String[] args) {
		
		EmployeeDataSource ds = new EmployeeDataSource();
		
		JdbcTemplate jt = new JdbcTemplate(ds);
		
		/*
		 * queryForList
		 */
		List<Integer> list =  jt.queryForList("select deptno from dept", Integer.class);
		
		for (int deptno : list) 
			log.info("deptno = " + deptno);
		
		/*
		 * queryForList 2
		 */
		List<String> list2 = jt.queryForList("select dname from dept where deptno > ? and deptno < ?", 
												new Object[] {10, 50}, 
												String.class);
		for (String dname : list2) 
			log.info("dname = " + dname);
		
		List<Map<String, Object>> list3 = jt.queryForList("select * from dept");
		
		for (Map<String, Object> row : list3) {
			log.info("deptno = " + row.get("deptno"));
			log.info("dname = " + row.get("dname"));
			log.info("loc = " + row.get("loc"));
		}
		
		jt.queryForMap("select * from dept");
		
	}
}




