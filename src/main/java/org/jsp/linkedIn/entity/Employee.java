package org.jsp.linkedIn.entity;

import java.time.LocalDate;
import java.util.*;

import org.hibernate.annotations.CreationTimestamp;
import org.jsp.linkedIn.util.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	@CreationTimestamp
	private LocalDate dateOfJoin;
	private String email;
	private double salary;
	private long phone;
	private String password;
	@Enumerated(EnumType.STRING)
	private Experience experience = Experience.FRESHER; // enum ----> EXPERIENCED || FRESHER
	@Enumerated(EnumType.STRING)
	private EmployeeStatus status = EmployeeStatus.ACTIVE; // enum ----> ACTIVE || IN_ACTIVE || BLOCKED ||
} 