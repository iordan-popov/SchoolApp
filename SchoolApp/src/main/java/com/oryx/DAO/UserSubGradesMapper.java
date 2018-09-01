package com.oryx.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;

import com.oryx.model.Grade;
import com.oryx.model.Subject;
import com.oryx.model.User;

public class UserSubGradesMapper implements RowMapper<User> {

	/*
	 * works over interfaces only
	 * 
	 * @Autowired private User user;
	 */

	public User mapRow(ResultSet rs, int arg1) throws SQLException {

		/*
		 * User user = new User(); Grade grade = new Grade();
		 */

		ApplicationContext ac = new ClassPathXmlApplicationContext("Beans.xml");

		User user = (User) ac.getBean("user");
		Grade grade = (Grade) ac.getBean("grade");

		user.setName(rs.getString("name"));
		grade.setGrade(rs.getInt("grade"));
		user.setGrade(grade);
		
		try {
			Subject subject = Subject.valueOf(rs.getString("subject"));
			user.setSubject(subject);
		} catch (NullPointerException e) {
			 System.out.println("NullPointerException caught");
		}
		
		

		return user;
	}

}
