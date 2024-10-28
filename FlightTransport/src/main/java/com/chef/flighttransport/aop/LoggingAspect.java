/**
 * 
 */
package com.chef.flighttransport.aop;



import java.text.DateFormat;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.chef.flighttransport.dto.FlightDTO;


/**
 * 
 */
@Component
@Aspect
public class LoggingAspect {

	private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

//	@Before("com.chef.flighttransport.aop.CommonAOP.logInsertFlight()")
//	public void logBeforeAdvice(JoinPoint jointPoint) {
//		Object[] args = jointPoint.getArgs();
//		logger.info("Adding the Flight details " + args[0].toString());
//	}
//
//	@After("com.chef.flighttransport.aop.CommonAOP.logInsertFlight()")
//	public void logAfterAdvice(JoinPoint jointPoint) {
//		Object[] args = jointPoint.getArgs();
//		FlightDTO flight = (FlightDTO) args[0];
//		logger.info("Details uploaded sucessfully for flight " + flight.getFlightNo());
//
//	}
	
	 // Logging for service methods
    @Around("com.chef.flighttransport.aop.CommonAOP.logServiceMethods()")
    public Object logServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        logger.info("Entering method: {} with arguments: {}", joinPoint.getSignature(), args);
        
        long startTime = System.currentTimeMillis();
        Object result;
        
        try {
            result = joinPoint.proceed();
        } catch (Exception e) {
            logger.error("Error in method: {} with arguments: {}", joinPoint.getSignature(), args, e);
            throw e; // Rethrow to allow further handling
        }
        
        long elapsedTime = System.currentTimeMillis() - startTime;
        logger.info("Exiting method: {} with result: {} (Execution time: {} ms)", 
                    joinPoint.getSignature(), result, elapsedTime);
        return result;
    }

    // Logging for repository methods
    @Around("com.chef.flighttransport.aop.CommonAOP.logRepositoryMethods()")
    public Object logRepositoryMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        logger.info("Repository method: {} with arguments: {}", joinPoint.getSignature(), args);
        
        Object result = joinPoint.proceed();
        logger.info("Repository method result: {}", result);
        return result;
    }

    // Logging for controller methods
    @Around("com.chef.flighttransport.aop.CommonAOP.logControllerMethods()")
    public Object logControllerMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        logger.info("Controller method: {} with arguments: {}", joinPoint.getSignature(), args);
        
        Object result = joinPoint.proceed();
        logger.info("Controller method result: {}", result);
        return result;
    }
	
//
//	@AfterReturning(pointcut = "execution(* com.chef.service.EmployeeServiceImpl.getAllEmployees(..))")
//	public void logAfterReturningAdvice(JoinPoint joinPoint) {
//		logger.info("In AfterReturning Advice, Joinpoint signature :{}", joinPoint.getSignature());
//	}
//
//	@AfterReturning(pointcut = "execution(* com.chef.service.EmployeeServiceImpl.getAllEmployees(..))", returning = "result")
//	public void logAfterReturningDetails(JoinPoint joinPoint, List<EmployeeDTO> result) {
//		logger.info("In AfterReturning Advice with return value, Joinpoint signature :{}", joinPoint.getSignature());
//		System.out.println(result);
//		long time = System.currentTimeMillis();
//		String date = DateFormat.getDateTimeInstance().format(time);
//		logger.info("Report generated at time:{}", date);
//	}
//
//	@AfterThrowing("execution(* com.chef.service.EmployeeServiceImpl.getAllEmployees(..))")
//	public void logAfterThrowingAdvice(JoinPoint joinPoint) {
//		logger.info("In After throwing Advice, Joinpoint signature :{}", joinPoint.getSignature());
//	}
//
//	@AfterThrowing(pointcut = "execution(* com.chef.service.EmployeeServiceImpl.getAllEmployees(..))", throwing = "exception")
//	public void logAfterThrowingAdviceDetails(JoinPoint joinPoint, Exception exception) {
//		logger.info("In After throwing Advice, Joinpoint signature :{}", joinPoint.getSignature());
//		logger.error(exception.getMessage(), exception);
//	}
//
//	@Around("execution(* com.chef.service.EmployeeServiceImpl.getAllEmployees(..))(..))")
//	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
//		System.out.println("Before proceeding part of the Around advice.");
//		Object cust = joinPoint.proceed();
//		System.out.println("After proceeding part of the Around advice.");
//		return cust;
//	}
}
