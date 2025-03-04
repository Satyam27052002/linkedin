package org.jsp.linkedIn.controller;

import org.jsp.linkedIn.entity.*;
import org.jsp.linkedIn.responsestructure.ResponseStructure;
import org.jsp.linkedIn.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/educations")
public class EducationController 
{
	@Autowired
	private EducationService service;
	@PostMapping("/{id}")
	public ResponseStructure<Education> saveEducation(@RequestBody Education education, @PathVariable int eid)
	{
		return service.saveEducation(education,eid);
	}	
}