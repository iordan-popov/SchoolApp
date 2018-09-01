package com.oryx.DAO;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class GradeDaoImpl implements GradeDAO {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource ds) { // uses bean constructor
		this.dataSource = ds;
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}

	public void updateGrade(int grade, int subjectID, int studentID, int newGrade) {
		
		String sql = "UPDATE grade SET grade="+ newGrade  +" WHERE subject_id =" + subjectID +
				" AND " + "student_id= " + studentID +";";
		jdbcTemplate.update(sql);
	}

}
