package com.oryx.DAO;

import java.util.List;
import javax.sql.DataSource;
import com.oryx.model.Login;
import com.oryx.model.User;

public interface UserDAO {

	public void setDataSource(DataSource ds);

	public void create(String name, String username, String pass);

	public User getUser(int id);
	
	public User validateUser(Login login);

	public List<User> listNameGradeSubjectOfUsers();
	
	public List<User> listUser(Login login);

	public void registerUser(User user);
	
	public void insertUserMark(int grade, int subjectID, int studentID);
	
	public int getUserID(String name);

	public void deleteUserMark(int grade, int subjectID, int studentID);
	
	public List<User> listUsersOnly();
	
}
