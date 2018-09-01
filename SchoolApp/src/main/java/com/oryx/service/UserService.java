package com.oryx.service;

import java.util.List;

import com.oryx.model.Login;
import com.oryx.model.User;

public interface UserService {
	
	public int getUserID(String name);

	public void register(User user);

	public User validateUser(Login login);

	public List<User> listNameGradeSubjectOfUsers();

	public List<User> listUser(Login Login);

	public void insertUserMark(int grade, int subjectID, int studentID);

	public void deleteMark(int grade, int subjectID, int studentID);
	
	public List<User> listUsersOnly();

}
