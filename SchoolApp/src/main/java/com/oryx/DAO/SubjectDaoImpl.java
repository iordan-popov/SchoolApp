package com.oryx.DAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class SubjectDaoImpl implements SubjectDAO {

	@Autowired
	private DataSource datasource;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource ds) {
		this.datasource = ds;
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	public int getSubjectID(String subName) {

		String sql = "SELECT subject.id FROM subject WHERE name='" + subName + "';";
		List<Integer> x = jdbcTemplate.query(sql, new SubjectIdMapper());
		return x.get(0);
	}

	public List listSubjects() {
		
		String sql = "SELECT subject.name FROM subject";
		
		List<String> namesList = jdbcTemplate.query(sql, new SubjectNameMapper());
		
		return namesList;
	}

}
