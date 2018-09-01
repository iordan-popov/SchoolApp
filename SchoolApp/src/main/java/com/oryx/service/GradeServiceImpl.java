package com.oryx.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.oryx.DAO.GradeDAO;

public class GradeServiceImpl implements GradeService {

	@Autowired
	GradeDAO gradeDAO;

	public void updateGrade(int grade, int subjectID, int studentID, int newGrade) {

		gradeDAO.updateGrade(grade, subjectID, studentID, newGrade);

	}

}
