package org.jsp.linkedIn.exception;
import org.jsp.linkedIn.responsestructure.ResponseStructure;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class EmployeeExceptionHandler 
{
	@ExceptionHandler(RuntimeException.class)
	public ResponseStructure<String> runtimeExceptionHandler(RuntimeException e)
	{
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(200);
		structure.setMessage(null);
		structure.setBody(null);
		return structure;
	}
}
