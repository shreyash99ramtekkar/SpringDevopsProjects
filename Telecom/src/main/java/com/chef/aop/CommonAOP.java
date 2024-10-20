/**
 * 
 */
package com.chef.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 
 */
@Aspect
public class CommonAOP {

//		// pointcut declarations
//		@Pointcut("execution(* com.chef.service.EmployeeServiceImpl.updateCustomer(..))")
//		public void logUpdateCustomer() {
//			/* pointcut declaration */}
		@Pointcut("execution(* com.chef.service.EmployeeServiceImpl.delete(..))")
		public void logDeleteCustomer() {
			/* pointcut declaration */}
		@Pointcut("execution(* com.chef.service.EmployeeServiceImpl.getAllEmployees(..))")
		public void logFetchCustomer() {
			/* pointcut declaration */ }
	


}
