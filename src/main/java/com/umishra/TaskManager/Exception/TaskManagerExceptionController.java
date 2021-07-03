package com.umishra.TaskManager.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TaskManagerExceptionController {

	@ExceptionHandler(value = QuoteNotfoundException.class)
	public String exception(QuoteNotfoundException exception) {
		exception.printStackTrace();
		return "error-404";
	}
	
	@ExceptionHandler(value = Exception.class)
	public String genricException(Exception exception) {
		exception.printStackTrace();
		return "error";
	}
	
}
