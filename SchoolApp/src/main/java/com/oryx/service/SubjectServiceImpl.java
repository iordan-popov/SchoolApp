package com.oryx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.oryx.DAO.SubjectDAO;

public class SubjectServiceImpl implements SubjectService {

	@Autowired
	public SubjectDAO subjectDAO;
	
	
	public int getSubjectID(String name) {
		
		return subjectDAO.getSubjectID(name); //throws exception
		
	}


	public List listSubjects() {
		
		return subjectDAO.listSubjects();
	}

}
