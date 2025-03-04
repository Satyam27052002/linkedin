package org.jsp.linkedIn.entity;

import org.jsp.linkedIn.util.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Education 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String qualification;
	private String universityName;
	private double percentage;
	private int completionYear;
	@Enumerated(EnumType.STRING)
	private HighestQualification highestQualification=HighestQualification.YES; // enum ----> YES || NO
	@Enumerated(EnumType.STRING)
	private EducationStatus status = EducationStatus.ACTIVE;// enum ----> ACTIVE || IN_ACTIVE 
	@ManyToOne
	private Employee employee;
}
