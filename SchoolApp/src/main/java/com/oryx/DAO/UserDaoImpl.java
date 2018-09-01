package com.oryx.DAO;

import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.oryx.model.Login;
import com.oryx.model.User;

public class UserDaoImpl implements UserDAO {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource ds) { // uses bean constructor
		this.dataSource = ds;
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}

	public int getUserID(String name) {

		String sql = "SELECT id FROM student WHERE student.name='" + name + "';";

		List<Integer> user = jdbcTemplate.query(sql, new UserGetIDMapper());

		return user.get(0);
	}

	public void create(String name, String username, String pass) {
		// TODO Auto-generated method stub

	}

	public User getUser(int id) {
		String sql = "SELECT * FROM student where id = " + id + ";";

		User user = (User) jdbcTemplate.query(sql, new UserMapper());

		return null;
	}
	
	public List<User> listUsersOnly() {
		
		String sql = "SELECT name FROM schoolDB.student";
		
		List<User> users = jdbcTemplate.query(sql, new UserNameMapper());
		
		return users;
	}
	
	

	public List<User> listNameGradeSubjectOfUsers() {
		String sql = "SELECT student.name, grade.grade, subject.name AS subject FROM student"
				+ " join grade on student.id = grade.student_id" + " join subject ON grade.subject_id = subject.id"
				+ " ORDER BY student.name ASC;";

		List<User> users = jdbcTemplate.query(sql, new UserSubGradesMapper());

		return users;
	}

	public User validateUser(Login login) {

		String sql = "select * from student where username='" + login.getUsername() + "' and password='"
				+ login.getPassword()

				+ "'";

		List<User> users = jdbcTemplate.query(sql, new UserMapper());

		return users.size() > 0 ? users.get(0) : null;

	}

	public List<User> getUserSubjectGrades(Login login) {

		String sql = "SELECT * FROM student LEFT JOIN grade ON student.id = grade.student_id "
				+ "LEFT JOIN subject ON grade.subject_id = subject.id" + "ORDER BY student.name ASC;";

		List<User> users = jdbcTemplate.query(sql, new UserSubGradesMapper());

		return users;
	}

	public List<User> listUser(Login login) {

		String sql = "SELECT student.name, grade.grade, subject.name AS subject FROM student"
				+ " LEFT JOIN grade on student.id = grade.student_id"
				+ " LEFT JOIN subject on grade.subject_id = subject.id" + " WHERE student.username= '"
				+ login.getUsername() + "'";

		List<User> users = jdbcTemplate.query(sql, new UserSubGradesMapper());

		return users;
	}

	public void registerUser(User user) {

		String sql = "INSERT INTO student (name, username, password, admin)" + " VALUES (?, ?, ?, ?);";

		jdbcTemplate.update(sql,
				new Object[] { user.getName(), user.getUsername(), user.getPassword(), user.getAdmin() });
	}

	public void insertUserMark(int grade, int subjectID, int studentID) {
		String sql = "INSERT INTO grade( grade, subject_id, student_id) VALUES (?, ?, ?);";
		
		jdbcTemplate.update(sql, grade, subjectID, studentID);
	}

	public void deleteUserMark(int grade, int subjectID, int studentID) {
		String sql = "DELETE FROM grade where grade= ? AND subject_id = ? AND student_id =?;";
		
		jdbcTemplate.update(sql, grade, subjectID, studentID);
	}

}
