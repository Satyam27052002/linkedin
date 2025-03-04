package org.jsp.linkedIn.service;

import java.util.*;
import org.jsp.linkedIn.dao.*;
import org.jsp.linkedIn.entity.*;
import org.jsp.linkedIn.responsestructure.ResponseStructure;
import org.jsp.linkedIn.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
@Service
public class AddressService 
{
	@Autowired
	private AddressDao addressDao;
	@Autowired
	private EmployeeDao employeeDao;
	Optional<Employee> optional;
	Employee employee;
	Address address;
	Optional<Address> opt;
	ResponseStructure<Address> structure=new ResponseStructure();
	ResponseStructure<List<Address>> str=new ResponseStructure<>();
	
	public ResponseStructure<Address> saveAddress(Address address,int eid) 
	{
		optional=employeeDao.findEmployeeById(eid);
		if(optional.isEmpty())
		{
			//throw new InvalidEmployeeIdException();
		}
		employee=optional.get();
		address.setEmployee(employee);
		address=addressDao.saveAddress(address);
		structure.setStatus(200);
		structure.setMessage("address saved");
		structure.setBody(address);
		return structure;
	}

	public ResponseStructure<Address> fetchAddress(int aid) 
	{	
		opt= addressDao.fetchAddress(aid);
		if (opt.isEmpty()) 
		{
//	        throw new NoAddressFoundException("No addresses found for employee ID " + eid);
	    }
		address=opt.get();
		structure.setStatus(200);
		structure.setMessage("address found");
		structure.setBody(address);
		return structure;
	}

	public ResponseStructure<Address> setAddressType(int aid, AddressType type) 
	{
		opt= addressDao.fetchAddress(aid);
		if (opt.isEmpty()) 
		{
//	        throw new NoAddressFoundException("No addresses found for employee ID " + eid);
	    }
		address=opt.get();
		address.setType(type);
		Address a=addressDao.saveAddress(address);
		structure.setStatus(200);
		structure.setMessage("address updated");
		structure.setBody(a);
		return structure;
	}

	public ResponseStructure<Address> setAddressType(int aid, AddressStatus status) 
	{
		opt= addressDao.fetchAddress(aid);
		if (opt.isEmpty()) 
		{
//	        throw new NoAddressFoundException("No addresses found for employee ID " + eid);
	    }
		address=opt.get();
		address.setStatus(status);
		Address a=addressDao.saveAddress(address);
		structure.setStatus(200);
		structure.setMessage("address updated");
		structure.setBody(a);
		return structure;
	}
}
