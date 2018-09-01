package com.oryx.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;
import com.oryx.model.User;

public class UserNameMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int arg1) throws SQLException {

		ApplicationContext ac = new ClassPathXmlApplicationContext("Beans.xml");
		User user = (User) ac.getBean("user");

		user.setName(rs.getString("name"));

		return user;
	}
}
