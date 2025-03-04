package org.jsp.linkedIn.entity;

import org.jsp.linkedIn.util.AddressStatus;
import org.jsp.linkedIn.util.AddressType;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String doorNo;
	private String addressLine1;
	private String addressLine2; // Optional
	private String landmark;
	private String city;
	private String state;
	private String country;
	private int pincode;
	@Enumerated(EnumType.STRING)
	private AddressStatus status = AddressStatus.ACTIVE;
	@Enumerated(EnumType.STRING)
	private AddressType type=AddressType.WORK;// enum ----> PERMANENT || PRESENT || WORK || HOME
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
}
//GET  --> 		/addresses/{eid}								--> fetch all address of an employee