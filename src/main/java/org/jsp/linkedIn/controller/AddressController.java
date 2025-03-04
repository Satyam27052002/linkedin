package org.jsp.linkedIn.controller;

import java.util.*;
import org.jsp.linkedIn.entity.*;
import org.jsp.linkedIn.responsestructure.ResponseStructure;
import org.jsp.linkedIn.service.*;
import org.jsp.linkedIn.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addresses")
public class AddressController 
{
	@Autowired
	private AddressService service;
	
	@PostMapping("/{eid}")
	public ResponseStructure<Address> saveAddress(@RequestBody Address address,@PathVariable int eid)
	{
		return service.saveAddress(address,eid);
	}
	
	@GetMapping("/{aid}")
	public ResponseStructure<Address> fetchAddress(@PathVariable int aid)
	{
		return service.fetchAddress(aid);
	}
	
	@PatchMapping("/type/{aid}/{type}")
	public ResponseStructure<Address> setAddressType(@PathVariable int aid,@PathVariable AddressType type)
	{
		return service.setAddressType(aid,type);
	}
	
	@PatchMapping("/status/{aid}/{status}")
	public ResponseStructure<Address> setAddressType(@PathVariable int aid,@PathVariable AddressStatus status)
	{
		return service.setAddressType(aid,status);
	}
}
