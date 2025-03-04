package org.jsp.linkedIn.service;

import java.util.*;

import org.jsp.linkedIn.dao.*;
import org.jsp.linkedIn.entity.*;
import org.jsp.linkedIn.responsestructure.ResponseStructure;
import org.jsp.linkedIn.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService 
{
	@Autowired
	private EmployeeDao dao;
	
	ResponseStructure<Employee> structure = new ResponseStructure<>();
	ResponseStructure<List<Employee>> str = new ResponseStructure<>();
	Optional<Employee> optional;
	List<Employee> emps;
	Employee emp;

	public ResponseStructure<Employee> saveEmployee(Employee employee) 
	{
		employee = dao.saveEmployee(employee);
		structure.setStatus(200);
		structure.setMessage("Employee Saved Successfully");
		structure.setBody(employee);
		return structure;
	}

	public ResponseStructure<List<Employee>> findAllEmployees() 
	{
		emps = dao.findAllEmployees();
		if (emps.isEmpty()) 
		{
//			throw new NoEmployeeFoundException();
		}
		str.setStatus(200);
		str.setMessage("All Employees Found Successfully");
		str.setBody(emps);
		return str;
	}

	public ResponseStructure<List<Employee>> findAllActiveEmployees() 
	{
		emps = dao.findAllActiveEmployees();
		if (emps.isEmpty()) 
		{
//			throw new NoEmployeeFoundException();
		}
		str.setStatus(200);
		str.setMessage("All Employees Found Successfully");
		str.setBody(emps);
		return str;
	}

	public ResponseStructure<Employee> findEmployeeById(int id) 
	{

		optional = dao.findEmployeeById(id);
		if (optional.isEmpty()) 
		{
//			throw new InvalidEmployeeIdException();
		}
		emp = optional.get();
		structure.setStatus(200);
		structure.setMessage("Employyee Found Successfully");
		structure.setBody(emp);
		return structure;
	}

	public ResponseStructure<List<Employee>> findAllInActiveEmployees() 
	{
		emps = dao.findAllActiveEmployees();
		if (emps.isEmpty()) 
		{
//			throw new NoEmployeeFoundException();
		}
		str.setStatus(200);
		str.setMessage("All Employees Found Successfully");
		str.setBody(emps);
		return str;
	}

	public ResponseStructure<Employee> login(String email, String password) 
	{
		emp=dao.login(email,password);
		if(emp!=null)
		{
			structure.setStatus(200);
			structure.setMessage("login successful");
			structure.setBody(emp);
		}
		else
		{
			structure.setStatus(401); // 401 Unauthorized
			structure.setMessage("Invalid email or password");
			structure.setBody(null);
		}
		return structure;
	}

	public ResponseStructure<Employee> setEmployeeStatus(int eid, EmployeeStatus status) 
	{
		optional = dao.findEmployeeById(eid);
		if (optional.isEmpty()) 
		{
//			throw new InvalidEmployeeIdException();
		}
		emp = optional.get();
		emp.setStatus(status);
		Employee e=dao.saveEmployee(emp);
		structure.setStatus(200);
		structure.setMessage("update successful");
		structure.setBody(e);
		return structure;
	}
}
