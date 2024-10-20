/**
 * 
 */
package com.chef.aop;
import java.util.List;

import java.text.DateFormat;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.chef.dto.EmployeeDTO;

/**
 * 
 */
@Component
@Aspect
public class LoggingAspect {

	private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	@Before("com.chef.aop.CommonAOP.logFetchCustomer()")
	public void logBeforeAdvice(JoinPoint jointPoint) {
		logger.info("In Before Advice, Joinpoint signature : {}", jointPoint.getSignature());
		long time = System.currentTimeMillis();
		String date = DateFormat.getDateTimeInstance().format(time);
		logger.info("Report Generated at time: {}", date);
	}

	@After("execution(* com.chef.service.EmployeeServiceImpl.getAllEmployees(..))")
	public void logAfterAdvice(JoinPoint joinPoint) {
		logger.info("In After Advice, Joinpoint signature: {}", joinPoint.getSignature());
		long time = System.currentTimeMillis();
		String date = DateFormat.getDateInstance().format(time);
		logger.info("Report Generated at time: {}", date);

	}

	@AfterReturning(pointcut = "execution(* com.chef.service.EmployeeServiceImpl.getAllEmployees(..))")
	public void logAfterReturningAdvice(JoinPoint joinPoint) {
		logger.info("In AfterReturning Advice, Joinpoint signature :{}", joinPoint.getSignature());
	}

	@AfterReturning(pointcut = "execution(* com.chef.service.EmployeeServiceImpl.getAllEmployees(..))", returning = "result")
	public void logAfterReturningDetails(JoinPoint joinPoint, List<EmployeeDTO> result) {
		logger.info("In AfterReturning Advice with return value, Joinpoint signature :{}", joinPoint.getSignature());
		System.out.println(result);
		long time = System.currentTimeMillis();
		String date = DateFormat.getDateTimeInstance().format(time);
		logger.info("Report generated at time:{}", date);
	}

	@AfterThrowing("execution(* com.chef.service.EmployeeServiceImpl.getAllEmployees(..))")
	public void logAfterThrowingAdvice(JoinPoint joinPoint) {
		logger.info("In After throwing Advice, Joinpoint signature :{}", joinPoint.getSignature());
	}

	@AfterThrowing(pointcut = "execution(* com.chef.service.EmployeeServiceImpl.getAllEmployees(..))", throwing = "exception")
	public void logAfterThrowingAdviceDetails(JoinPoint joinPoint, Exception exception) {
		logger.info("In After throwing Advice, Joinpoint signature :{}", joinPoint.getSignature());
		logger.error(exception.getMessage(), exception);
	}

	@Around("execution(* com.chef.service.EmployeeServiceImpl.getAllEmployees(..))(..))")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Before proceeding part of the Around advice.");
		Object cust = joinPoint.proceed();
		System.out.println("After proceeding part of the Around advice.");
		return cust;
	}
}
