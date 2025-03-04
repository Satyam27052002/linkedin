package org.jsp.linkedIn.repository;

import java.util.*;
import org.jsp.linkedIn.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends JpaRepository<Address, Integer>
{
//	@Query("SELECT a FROM Address a WHERE a.employee = :employee")
//	List<Address> findByEmployee(@Param("employee") Employee employee);
}
