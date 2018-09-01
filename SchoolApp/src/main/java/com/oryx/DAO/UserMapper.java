package com.oryx.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;
import com.oryx.model.User;

public class UserMapper implements RowMapper<User> {
	
	
	/*@Autowired 
	private User user;
	*/
	

	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		// Extraction from Database using Result Set
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("Beans.xml");
		User user = (User)ac.getBean("user");
		
		
	/*	User user = new User();*/

		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setAdmin(rs.getInt("admin"));
		
		return user;
	}	
}
