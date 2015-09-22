package com.webapp.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.webapp.datasource.EmployeeDataSource;
import com.webapp.model.Dept;

//Singleton 싱글톤
public class DeptDao {
	
	JdbcTemplate template;
	private DeptDao() {
		template = new JdbcTemplate();
		template.setDataSource(new EmployeeDataSource());
	}

	static DeptDao deptdao;
	public static DeptDao newInstance() {
		if (deptdao == null)
			deptdao = new DeptDao();
		return deptdao;
	}

	public List<Dept> selectAll() {
		
		return template.query("select * from dept", 
							  new BeanPropertyRowMapper<Dept>(Dept.class));
	}
	
	public Dept selectByDeptno(int deptno) {
		
		return template.queryForObject("select * from dept where deptno = ?", 
										new Object[] {deptno}, 
										new BeanPropertyRowMapper<Dept>(Dept.class));
	}
	
	final static String INSERT = 
					"insert into dept " +
					"(                " +
					"	deptno,       " +
					"	dname,        " +
					"	loc           " +
					")                " +
					"values           " +
					"(                " +
					"	?,            " +
					"	?,            " +
					"	?             " +
					")                ";
	
	public int insert(Dept dept) {
		
		return template.update(INSERT, dept.getDeptno(), 
									   dept.getDname(),
									   dept.getLoc());
	}
	
	final static String UPDATE = 
			"update dept        " +
			"   set dname  = ?, " +
			"	    loc    = ?  " +
			" where deptno = ?  ";

	public int update(Dept dept) {
	
		return template.update(UPDATE, dept.getDname(),
									   dept.getLoc(),
									   dept.getDeptno());
	}
	
	public int delete(int deptno) {
		return template.update("delete from dept where deptno=?", deptno);
	}
	
	
}












