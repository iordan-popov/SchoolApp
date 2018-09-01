package com.oryx.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SubjectNameMapper implements RowMapper<String> {

	public String mapRow(ResultSet rs, int rowNum) throws SQLException {

		String subjectName = rs.getString("name");

		return subjectName;
	}

}
