package org.jsp.linkedIn.dao;

import org.jsp.linkedIn.entity.*;
import org.jsp.linkedIn.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EducationDao 
{
	@Autowired
	private EducationRepository repository;

	public Education saveEducation(Education education) 
	{
		return repository.save(education);
	}	
}