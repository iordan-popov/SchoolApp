package com.oryx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.oryx.DAO.UserDAO;
import com.oryx.model.Login;
import com.oryx.model.User;

public class UserServiceImpl implements UserService {

	@Autowired
	public UserDAO userDAO;

	public User validateUser(Login login) {
		return userDAO.validateUser(login);
	}

	public int getUserID(String name) {
		return userDAO.getUserID(name);
	}

	public void register(User user) {
		userDAO.registerUser(user);
	}

	public List<User> listUser(Login login) {
		return userDAO.listUser(login);
	}

	public List<User> listNameGradeSubjectOfUsers() {
		return userDAO.listNameGradeSubjectOfUsers();
	}

	public void insertUserMark(int grade, int subjectID, int studentID) {
		userDAO.insertUserMark(grade, subjectID, studentID);
	}

	public void deleteMark(int grade, int subjectID, int studentID) {
		userDAO.deleteUserMark(grade, subjectID, studentID);

	}

	public List<User> listUsersOnly() {		
		return userDAO.listUsersOnly();
	}

	public void updateGrade(int grade, int subjectID, int studentID, int newGrade) {
		// TODO Auto-generated method stub
		
	}

}
