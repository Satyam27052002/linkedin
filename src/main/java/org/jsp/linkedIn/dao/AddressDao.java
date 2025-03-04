package org.jsp.linkedIn.dao;

import org.springframework.stereotype.*;
import java.util.*;
import org.jsp.linkedIn.entity.*;
import org.jsp.linkedIn.repository.*;
import org.springframework.beans.factory.annotation.*;
@Repository
public class AddressDao
{
	@Autowired
	private AddressRepository repo;
	
	public Address saveAddress(Address address)
	{
		return repo.save(address);
	}

	public Optional<Address> fetchAddress(int aid) 
	{
		return repo.findById(aid);
	}
}