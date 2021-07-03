package com.umishra.TaskManager.Exception;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {

	public ExceptionController() {
	}
	
	@Controller
	public class MyErrorController implements ErrorController  {
		
		@Value("${service.status}")
		private String serviceStatus;

		@RequestMapping("/error")
		public String handleError(HttpServletRequest request) {
		    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		    
		    if (serviceStatus.equals("maintenance"))
		    	return "error-503";
		    	
		    if (status != null) {
		        Integer statusCode = Integer.valueOf(status.toString());
		    
		        if(statusCode == HttpStatus.NOT_FOUND.value()) {
		            return "error-404";
		        }
		        else if(statusCode == HttpStatus.SERVICE_UNAVAILABLE.value()) {
		            return "error-503";
		        }
		    }
		    return "error";
		}
		
		 @Override
		    public String getErrorPath() {
		        return null;
		    }
	}

}
