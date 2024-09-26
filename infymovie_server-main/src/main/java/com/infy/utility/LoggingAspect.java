package com.infy.utility;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * This class is to log exceptions which come while application is running.
 * 
 * @author ETA_JAVA
 *
 */
@Component
@Aspect
public class LoggingAspect {
	
	@AfterThrowing(pointcut = "execution(* com.infy.service.*Impl.*(..))", throwing = "exception")	
	public void logExceptionFromService(Exception exception) throws Exception {
		if (exception.getMessage()!=null && (exception.getMessage().contains("Service") || 
				 exception.getMessage().contains("Validator"))) {
			log(exception);
		}
		throw exception;

	}
	
	private void log(Exception exception) {
		Logger logger = LoggerFactory.getLogger(this.getClass());
		logger.error(exception.getMessage(), exception);
	}

}
