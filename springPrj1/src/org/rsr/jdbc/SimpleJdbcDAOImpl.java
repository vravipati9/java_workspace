package org.rsr.jdbc;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

public class SimpleJdbcDAOImpl extends SimpleJdbcDaoSupport {
	
	public int getExecutivesCount() {
		String str = "Select count(*) from Executives";
		
		return this.getJdbcTemplate().queryForInt(str);
	}
}
