package org.jsp.linkedIn.dao;

import java.util.*;
import org.jsp.linkedIn.entity.*;
import org.jsp.linkedIn.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao 
{
	@Autowired
	private EmployeeRepository repo;

	public Employee saveEmployee(Employee employee) 
	{
		return repo.save(employee);
	}

	public List<Employee> findAllEmployees() 
	{
		return repo.findAll();
	}

	public List<Employee> findAllActiveEmployees() 
	{
		return repo.findAllActiveEmployees();
	}

	public Optional<Employee> findEmployeeById(int id) 
	{
		return repo.findById(id);
	}

	public Employee login(String email, String password) 
	{
		return repo.findByEmailAndPassword(email,password);
	}
}