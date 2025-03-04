package org.jsp.linkedIn.service;

import java.util.*;

import org.jsp.linkedIn.dao.*;
import org.jsp.linkedIn.entity.*;
import org.jsp.linkedIn.responsestructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService {

	@Autowired
	private EducationDao educationDao;

	@Autowired
	private EmployeeDao employeeDao;

	public ResponseStructure<Education> saveEducation(Education education, int eid) 
	{
		Optional<Employee> optional = employeeDao.findEmployeeById(eid);
		if (optional.isEmpty()) 
		{
			// throw new InvalidEmployeeIdException();
		}
		Employee employee = optional.get();

		education.setEmployee(employee);

		education = educationDao.saveEducation(education);
		ResponseStructure<Education> structure = new ResponseStructure<>();
		structure.setStatus(200);
		structure.setMessage("Education Saved Successfully");
		structure.setBody(education);
		return structure;
	}
}
