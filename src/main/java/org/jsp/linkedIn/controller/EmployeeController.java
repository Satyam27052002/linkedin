package org.jsp.linkedIn.controller;

import java.util.*;
import org.jsp.linkedIn.entity.*;
import org.jsp.linkedIn.responsestructure.ResponseStructure;
import org.jsp.linkedIn.service.*;
import org.jsp.linkedIn.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/employees")
public class EmployeeController 
{	
	@Autowired
	private EmployeeService service ;
	
	@Operation(summary = "To Save an Employee" , description = "This APi is used to save an Employee Data")
	@ApiResponses(value= {@ApiResponse(description="user saved successfully",responseCode="200"),@ApiResponse(description="unable to save user",responseCode="400")})
	@PostMapping
	public ResponseStructure<Employee> saveEmployee(@RequestBody Employee employee)
	{
		return service.saveEmployee(employee);
	}
	
	@PostMapping("/login/{email}/{password}")
	public ResponseStructure<Employee> login(@PathVariable String email,@PathVariable String password)
	{
		return service.login(email,password);
	}
	
	@GetMapping
	public ResponseStructure<List<Employee>> findAllEmployees()
	{
		return service.findAllEmployees();
	}
	
	@GetMapping("/status/active")
	public ResponseStructure<List<Employee>> findAllActiveEmployees()
	{
		return service.findAllActiveEmployees();
	}
	
	@GetMapping("/status/inactive")
	public ResponseStructure<List<Employee>> findAllInActiveEmployees()
	{
		return service.findAllInActiveEmployees();
	}
	
	@GetMapping("/{id}")
	public ResponseStructure<Employee> findEmployeeById(@PathVariable int id)
	{
		return service.findEmployeeById(id);
	}	
	
	@PatchMapping("/status/{eid}/{status}")
	public ResponseStructure<Employee> setEmployeeStatus(@PathVariable int eid,@PathVariable EmployeeStatus status)
	{
		return service.setEmployeeStatus(eid,status);
	}
}