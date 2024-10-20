package com.chef;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.env.Environment;

import com.chef.dao.EmployeeRepository;
import com.chef.dao.EmployeeRepositoryImpl;
import com.chef.dto.EmployeeDTO;
import com.chef.service.CustomerService;
import com.chef.service.CustomerServiceImpl;
import com.chef.service.EmployeeService;
import com.chef.service.EmployeeServiceImpl;

@SpringBootApplication
public class TelecomApplication  implements ApplicationRunner{
	@Autowired
	Environment env;
	
	public static Logger logger = LoggerFactory.getLogger(TelecomApplication.class);
	
	@Autowired
	EmployeeService employeeService;

	
	
	public static void main(String[] args)  {
	    AbstractApplicationContext context = (AbstractApplicationContext)SpringApplication.run(TelecomApplication.class, args);
//	    CustomerService customerService = context.getBean(CustomerServiceImpl.class);
//	    EmployeeService employeeService = context.getBean(EmployeeServiceImpl.class);
//	    EmployeeService employeeService1 = context.getBean(EmployeeServiceImpl.class);
//	    System.out.println(employeeService.hashCode());
//	    System.out.println(employeeService1.hashCode());
//	    EmployeeRepository employeeRepo = context.getBean(EmployeeRepositoryImpl.class);
//	    EmployeeRepository employeeRepo1 = context.getBean(EmployeeRepositoryImpl.class);
//	    System.out.println(employeeRepo.hashCode());
//	    System.out.println(employeeRepo1.hashCode());
//	    logger.info(Integer.toString(employeeRepo1.hashCode()));

	  
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(env.getProperty("spring.application.name"));
		System.out.println("Some function need to perform before loading");
		  try {
			  	EmployeeDTO empDto = new EmployeeDTO();
				empDto.setEmpId(1);
				empDto.setDepartment("Finance");
				empDto.setEmpName("Itachi");
				
				employeeService.insert(empDto);
				for(EmployeeDTO emp : employeeService.getAllEmployees()) {
					System.out.println(emp.toString());
				}
				employeeService.delete(0);
				for(EmployeeDTO emp : employeeService.getAllEmployees()) {
					System.out.println(emp.toString());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
