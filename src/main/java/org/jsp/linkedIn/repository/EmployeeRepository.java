package org.jsp.linkedIn.repository;

import java.util.*;
import org.jsp.linkedIn.entity.Employee;
import org.springframework.data.jpa.repository.*;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
	@Query("select e from Employee e where e.status='ACTIVE'")
	List<Employee> findAllActiveEmployees();
	
	@Query("select e from Employee e where e.status='IN_ACTIVE'")
	List<Employee> findAllINActiveEmployees();
	
	Employee findByEmailAndPassword(String email,String password);
}