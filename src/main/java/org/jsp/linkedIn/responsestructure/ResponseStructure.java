package org.jsp.linkedIn.responsestructure;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseStructure<T> 
{
	private int status;
	private String message;
	private T body;
}
