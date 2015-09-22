package com.webapp.world;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.webapp.datasource.WorldDataSource;
import com.webapp.model.City;
import com.webapp.model.Country;

public class CitySelectTest {

	static Log log = LogFactory.getLog(CitySelectTest.class);
	public static void main(String[] args) {
		
		JdbcTemplate jt = new JdbcTemplate(new WorldDataSource());
		
		List<City> citys = jt.query("select * from city", new RowMapper<City>() {

			@Override
			public City mapRow(ResultSet rs, int rowNum) throws SQLException {
				City city = new City();
				city.setId(rs.getInt("id"));
				city.setName(rs.getString("name"));
				
				Country c = new Country();
				c.setCode(rs.getString("countrycode"));
				city.setCountry(c);
				
				return city;
			}
			
		});
		log.info("citys count = " + citys.size());
		
		
		

	}

}




