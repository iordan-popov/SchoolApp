package com.oryx.DAO;

import java.util.List;

public interface SubjectDAO {
	
	public int getSubjectID(String subName);

	public List listSubjects();

}
